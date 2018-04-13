package me.tassu.db.impl.mysql;

import com.google.common.base.MoreObjects;
import me.tassu.db.column.Column;
import me.tassu.db.util.DataType;

public class MySQLColumn implements Column {

    private final String name;
    private final DataType type;

    MySQLColumn(String name, DataType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DataType getType() {
        return type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("type", type)
                .toString();
    }
}
