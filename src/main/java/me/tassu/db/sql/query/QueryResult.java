package me.tassu.db.sql.query;

import me.tassu.db.util.DataType;

import java.util.Map;

/**
 * Represents a result of {@link Query}.
 * @author tassu
 * @see Query
 * @see me.tassu.db.sql.SQLDatabase
 * @see me.tassu.db.sql.table.Table
 * @author tassu
 * @version 1.0
 * @since 1.0
 */
public interface QueryResult {

    default Map<String, DataType> getColumns() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    default Object get(String column) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    default String getString(String column) {
        return (String) get(column);
    }

}
