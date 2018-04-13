package me.tassu.db.sql.table;

import me.tassu.db.sql.column.Column;

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
    String getName();

    /**
     * @return all columns of this table
     */
    Column[] getColumns();

    /**
     * sets primary columns of this table
     * @param identifiers primary key column ids
     * @return builder
     */
    Table setPrimaryColumns(String... identifiers);

}
