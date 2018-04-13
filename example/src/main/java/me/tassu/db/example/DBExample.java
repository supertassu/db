package me.tassu.db.example;

import me.tassu.db.impl.mysql.MySQLDatabase;

public class DBExample {

    public static void main(String[] args) {
        MySQLDatabase database = MySQLDatabase.builder()
                .host("localhost")
                .port(3306)
                .username("root")
                .password("root")
                .database("test")
                .build();


    }

}
