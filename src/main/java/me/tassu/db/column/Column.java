package me.tassu.db.column;

import me.tassu.db.util.DataType;

public interface Column {

    String getName();
    DataType getType();

    Column setAllowNull(boolean allowNull);
    boolean doesAllowNull();

}
