package me.tassu.db.table;

import me.tassu.db.column.Column;
import me.tassu.db.util.DataType;

public interface Table {

    String getName();

    Column[] getColumns();

    Table setPrimaryColumns(String... identifiers);

}
