package me.tassu.db;

import me.tassu.db.column.Column;
import me.tassu.db.table.Table;
import me.tassu.db.util.DataType;

import java.sql.Connection;

public interface Database {

    Connection getConnection();

    Column column(String name, DataType dataType);
    Table table(String name, Column... columns);

    String getTypeAsString(DataType type);

}
