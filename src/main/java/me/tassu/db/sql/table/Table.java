package me.tassu.db.sql.table;

import me.tassu.db.sql.column.Column;
import me.tassu.db.sql.query.Query;
import me.tassu.db.sql.query.QueryResult;
import me.tassu.db.util.Pair;

/**
 * Represents a table on the database.
 * @author tassu
 * @version 1.0
 * @since 1.0
 */
public interface Table {

    /**
     * @return the name of this table
     */
    default String getName() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * @return all columns of this table
     */
    default Column[] getColumns() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * sets primary columns of this table
     * @param identifiers primary key column ids
     * @return builder
     */
    default Table setPrimaryColumns(String... identifiers) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    default Query prepareQuery(Pair<String, Object>[] arguments) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default QueryResult executeQuery(Pair<String, Object>[] arguments) {
        return prepareQuery(arguments).compete();
    }

}
