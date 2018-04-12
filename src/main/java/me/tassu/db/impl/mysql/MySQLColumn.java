package me.tassu.db.impl.mysql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
}
