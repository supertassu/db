package me.tassu.db.sql.query;

import me.tassu.db.sql.column.Column;
import me.tassu.db.util.DataType;

import java.util.Map;

/**
 * Represents a row in a {@link me.tassu.db.sql.table.Table}.
 * @see QueryResult
 * @author tassu
 * @since 1.0
 */
public interface Row {

    /**
     * @see QueryResult#getColumns()
     * @return all columns in the query results
     */
    default Map<String, DataType> getColumns() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Checks if the specified column is on the table.
     * @param column specified column
     * @return true if the specified column is on the table, false otherwise
     */
    default boolean hasColumn(Column column) {
        return hasColumn(column.getName());
    }

    /**
     * Checks if the specified column is on the table.
     * @param column specified column
     * @return true if the specified column is on the table, false otherwise
     */
    default boolean hasColumn(String column) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * @see #get(String)
     * @param column specified column
     * @return returns the value from the specified column, null otherwise
     */
    default Object get(Column column) {
        return get(column.getName());
    }

    /**
     * @param column specified column
     * @return returns the value from the specified column, null otherwise
     */
    default Object get(String column) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * @param column specified column
     * @return returns the value from the specified column as string, null otherwise
     * @throws ClassCastException if the value was not string
     */
    default String getString(String column) {
        return (String) get(column);
    }

}
