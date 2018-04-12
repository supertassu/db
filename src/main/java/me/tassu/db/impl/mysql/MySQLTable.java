package me.tassu.db.impl.mysql;

import me.tassu.db.column.Column;
import me.tassu.db.table.Table;

import java.util.Set;
import java.util.stream.Collectors;

import static me.tassu.db.util.ArrayUtil.isStringInArray;

public class MySQLTable implements Table {

    private final String name;
    private final Set<Column> columns;
    @SuppressWarnings({"FieldCanBeLocal", "unused"}) // TODO remove (& fix) before release
    private Set<String> primaryColumns = null;

    MySQLTable(String name, Set<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    @Override
    public Column[] getColumns() {
        return columns.toArray(new Column[0]);
    }

    @Override
    public Table setPrimaryColumns(String... identifiers) {
        primaryColumns = columns.stream().filter(column -> isStringInArray(column.getName(), identifiers)).map(Column::getName).collect(Collectors.toSet());
        return this;
    }

    @Override
    public String getName() {
        return name;
    }
}
