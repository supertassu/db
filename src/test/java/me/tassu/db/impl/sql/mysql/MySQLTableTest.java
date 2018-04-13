package me.tassu.db.impl.sql.mysql;

import com.google.common.collect.Sets;
import me.tassu.db.sql.util.DataType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MySQLTableTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testNoColumnsInitSchema() {
        new MySQLTable("empty_table", Sets.newHashSet()).generateInitializationSchema();
    }

    @Test
    public void testOneColumnInitSchema() {
        assertEquals("CREATE TABLE `hello_world` (`greeting` TEXT PRIMARY KEY NOT NULL);",
                new MySQLTable("hello_world", Sets.newHashSet(new MySQLColumn("greeting", DataType.STRING)))
                        .setPrimaryColumns("greeting").generateInitializationSchema());
    }

    @Test
    public void testTwoColumnsInitSchema() {
        assertEquals("CREATE TABLE `hi_this_is_a_table` (`field` TEXT NOT NULL,`boolean` BOOLEAN);",
                new MySQLTable("hi_this_is_a_table", Sets.newHashSet(
                        new MySQLColumn("boolean", DataType.BOOLEAN).setAllowNull(true),
                        new MySQLColumn("field", DataType.STRING)))
                        .generateInitializationSchema());
    }
}
