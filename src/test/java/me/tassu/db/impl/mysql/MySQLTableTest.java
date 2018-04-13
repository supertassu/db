package me.tassu.db.impl.mysql;

import com.google.common.collect.Sets;
import me.tassu.db.util.DataType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MySQLTableTest {

    @Test
    public void generateInitializationSchema() {
        assertEquals("CREATE TABLE `hello_world` (`greeting` TEXT PRIMARY KEY NOT NULL);",
                new MySQLTable("hello_world", Sets.newHashSet(new MySQLColumn("greeting", DataType.STRING)))
                        .setPrimaryColumns("greeting").generateInitializationSchema());
    }
}
