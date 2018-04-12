package me.tassu.db.impl.mysql;

import com.google.common.collect.Sets;
import me.tassu.db.Database;
import me.tassu.db.column.Column;
import me.tassu.db.table.Table;
import me.tassu.db.util.DataType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements Database {

    private Connection connection;

    private MySQLDatabase(Builder builder) {
        this.connection = builder.connection;
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
        return null;
    }

    @Override
    public Column column(String name, DataType dataType) {
        return new MySQLColumn(name, dataType);
    }

    @Override
    public Table table(String name, Column... columns) {
        return new MySQLTable(name, Sets.newHashSet(columns));
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

    public void openConnection() throws SQLException, ClassNotFoundException {
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

    public static final class Builder {
        private Connection connection;
        private String host;
        private String database;
        private String username;
        private String password;
        private int port;

        private Builder() {
        }

        public MySQLDatabase build() {
            return new MySQLDatabase(this);
        }

        public Builder connection(Connection connection) {
            this.connection = connection;
            return this;
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
