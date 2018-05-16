package me.tassu.db.sql.query;

import com.google.common.collect.Maps;
import me.tassu.db.util.DataType;

import java.util.Map;
import java.util.Optional;

/**
 * Represents a result of {@link Query}.
 * @see Query
 * @see Row
 * @see me.tassu.db.sql.SQLDatabase
 * @see me.tassu.db.sql.table.Table
 * @author tassu
 * @version 1.0
 * @since 1.0
 */
public interface QueryResult {

    /**
     * @return all columns in the query results
     */
    default Map<String, DataType> getColumns() {
        return next(false).map(Row::getColumns).orElse(Maps.newHashMap());
    }

    /**
     * @return amount of rows in the queue
     */
    default int size() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * @return true if there os at least 1 row in the queue, false otherwise
     */
    default boolean hasNext() {
        return size() != 0;
    }

    /**
     * @see #next(boolean)
     * @return next row from the queue
     */
    default Optional<Row> next() {
        return next(true);
    }

    /**
     * Returns the next row from the queue.
     * @param remove should the table be removed from the queue.
     * @return next row from the queue
     */
    default Optional<Row> next(boolean remove) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
