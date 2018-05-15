package me.tassu.db.sql;

import me.tassu.db.sql.column.Column;
import me.tassu.db.sql.table.Table;
import me.tassu.db.util.DataType;

import java.sql.Connection;

/**
 * Represents a sql (tables etc) database connection.
 * @author tassu
 * @version 1.0
 * @since 1.0
 * @see me.tassu.db.kv.KeyValueDatabase
 */
public interface SQLDatabase {

    /**
     * @return the connection to database
     */
    default Connection getConnection() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Creates and initializes a column for this database.
     * @param name column name
     * @param dataType column type
     * @return the column
     */
    default Column column(String name, DataType dataType) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Creates and initializes a table for this database.
     * @param name table name
     * @param columns table columns
     * @return the table
     */
    default Table table(String name, Column... columns) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
