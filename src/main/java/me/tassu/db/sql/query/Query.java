package me.tassu.db.sql.query;

/**
 * Represents a query that fetches data from a {@link me.tassu.db.sql.table.Table}
 * @see me.tassu.db.sql.SQLDatabase
 * @see me.tassu.db.sql.table.Table
 * @see me.tassu.db.sql.column.Column
 * @author tassu
 * @version 1.0
 * @since 1.0
 */
public interface Query {

    default QueryResult compete() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
