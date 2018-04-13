package me.tassu.db.sql.column;

import me.tassu.db.sql.util.DataType;

/**
 * Represents a column on a table.
 * @author tassu
 * @version 1.0
 * @since 1.0
 */
public interface Column {

    /**
     * @return the name of this column
     */
    String getName();

    /**
     * @return the type of this column
     */
    DataType getType();

    /**
     * sets the "allow null" value for this column
     * @param allowNull "allow null" value
     * @return builder
     */
    Column setAllowNull(boolean allowNull);

    /**
     * the default value is defined by the implementation
     * @return the "allow null" value for this column
     */
    boolean doesAllowNull();

}
