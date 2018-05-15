package me.tassu.db.impl.sql.mysql;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import me.tassu.db.sql.column.Column;
import me.tassu.db.sql.query.Query;
import me.tassu.db.sql.table.Table;

import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

import static me.tassu.db.util.ArrayUtil.isStringInArray;

public class MySQLTable implements Table {

    private final String name;
    private final Set<Column> columns;
    private Set<String> primaryColumns = Sets.newHashSet();

    MySQLTable(String name, Set<Column> columns) {
        if (columns == null || columns.isEmpty()) throw new IllegalArgumentException("table requires at least one column");
        Preconditions.checkNotNull(name);
        this.name = name;
        this.columns = columns;
    }

    @Override
    public Column[] getColumns() {
        return columns.toArray(new Column[0]);
    }

    @Override
    public MySQLTable setPrimaryColumns(String... identifiers) {
        primaryColumns = columns.stream().filter(column -> isStringInArray(column.getName(), identifiers)).map(Column::getName).collect(Collectors.toSet());
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("columns", columns)
                .add("primaryColumns", primaryColumns)
                .toString();
    }

    /**
     * Initializes this table with specified database
     * @param database the database
     * @return was the initialization successful
     * @throws SQLException thrown when something went wrong
     */
    boolean initialize(MySQLDatabase database) throws SQLException {
        return database.getConnection().prepareStatement(generateInitializationSchema()).execute();
    }

    String generateInitializationSchema() {
        if (columns == null || columns.isEmpty()) throw new UnsupportedOperationException("table requires at least one column");

        final StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE `").append(this.getName()).append("` (");

        columns.stream().map(it -> (MySQLColumn) it).forEach(it -> {
            builder.append("`").append(it.getName()).append("` ").append(MySQLDatabase.getTypeAsString(it.getType()));
            if (primaryColumns.contains(it.getName())) {
                builder.append(" PRIMARY KEY NOT NULL");
            } else if (!it.doesAllowNull()) {
                builder.append(" NOT NULL");
            }

            builder.append(",");
        });

        builder.deleteCharAt(builder.lastIndexOf(",")).append(");");

        return builder.toString();
    }

    @Override
    public Query prepareQuery(Object... arguments) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
