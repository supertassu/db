package me.tassu.db.impl.sql.sqlite;

import me.tassu.db.sql.SQLDatabase;
import me.tassu.db.sql.column.Column;
import me.tassu.db.sql.table.Table;
import me.tassu.db.sql.util.DataType;

import java.sql.Connection;

/**
 * TODO do this
 * {@inheritDoc}
 * @author tassu
 */
public class SQLiteDatabase implements SQLDatabase {

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Column column(String name, DataType dataType) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Table table(String name, Column... columns) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}