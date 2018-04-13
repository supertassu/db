package me.tassu.db.impl.mysql;

import com.google.common.base.MoreObjects;
import me.tassu.db.column.Column;
import me.tassu.db.util.DataType;

/**
 * {@inheritDoc}
 */
public class MySQLColumn implements Column {

    private final String name;
    private final DataType type;
    private boolean doesAllowNull = false;

    /**
     * Constructs a new MySQLColumn.
     * @param name column name
     * @param type column type
     */
    MySQLColumn(String name, DataType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataType getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Column setAllowNull(boolean allowNull) {
        this.doesAllowNull = allowNull;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doesAllowNull() {
        return doesAllowNull;
    }

    /**
     * @return this column as string
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("type", type)
                .add("doesAllowNull", doesAllowNull)
                .toString();
    }
}
