package me.tassu.db.example;

import me.tassu.db.column.Column;
import me.tassu.db.impl.mysql.MySQLDatabase;
import me.tassu.db.table.Table;
import me.tassu.db.util.DataType;

public class DBExample {

    public static void main(String[] args) {
        MySQLDatabase database = MySQLDatabase.builder()
                .host("localhost")
                .port(3306)
                .username("root")
                .password("root")
                .database("test")
                .build();

        Column[] columns = new Column[] {
                database.column("random_column", DataType.STRING),
                database.column("another_column", DataType.INTEGER),
                database.column("is_it_good", DataType.BOOLEAN),
                database.column("how_am_i_supposed_to_get_ideas_from_names", DataType.NUMBER),
                database.column("im_finally_done", DataType.LONG_INTEGER)
        };

        Table table = database.table("random_table", columns).setPrimaryColumns("random_column");

        System.out.print(table.toString());

    }

}
