package me.tassu.db.impl.sqlite;

import me.tassu.db.Database;
import me.tassu.db.column.Column;
import me.tassu.db.table.Table;
import me.tassu.db.util.DataType;

import java.sql.Connection;

/**
 * TODO do this
 * @author tassu
 */
public class SQLiteDatabase implements Database {

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Column column(String name, DataType dataType) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Table table(String name, Column... columns) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
