package me.tassu.db.impl.mysql;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import me.tassu.db.Database;
import me.tassu.db.column.Column;
import me.tassu.db.table.Table;
import me.tassu.db.util.DataType;

import java.sql.*;

public class MySQLDatabase implements Database {

    private Connection connection;

    private MySQLDatabase(Builder builder) {
        this.host = builder.host;
        this.database = builder.database;
        this.username = builder.username;
        this.password = builder.password;
        this.port = builder.port;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                openConnection();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    @Override
    public Column column(String name, DataType dataType) {
        return new MySQLColumn(name, dataType);
    }

    @Override
    public Table table(String name, Column... columns) {
        MySQLTable table = new MySQLTable(name, Sets.newHashSet(columns));

        try {
            DatabaseMetaData metaData = getConnection().getMetaData();
            ResultSet set = metaData.getTables(null, null, table.getName(), new String[] {"TABLE"});

            if (!set.next()) {
                table.initialize(this);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return table;
    }

    @Override
    public String getTypeAsString(DataType type) {
        switch (type) {
            case STRING:
                return "TEXT";
            case BOOLEAN:
                return "BOOLEAN";
            case INTEGER:
                return "INTEGER";
            case LONG_INTEGER:
                return "BIGINT";
            case NUMBER:
                return "FLOAT(32767,32767)";
            default:
                throw new UnsupportedOperationException("Not implemented yet.");
        }
    }

    private String host, database, username, password;
    private int port;

    private void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("connection", connection)
                .add("host", host)
                .add("database", database)
                .add("username", username)
                .add("password", password)
                .add("port", port)
                .toString();
    }

    public static final class Builder {
        private String host;
        private String database;
        private String username;
        private String password;
        private int port;

        private Builder() {}

        public MySQLDatabase build() {
            return new MySQLDatabase(this);
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }
    }
}
