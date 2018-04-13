package me.tassu.db.util;

import org.junit.Test;

import static me.tassu.db.util.ArrayUtil.isStringInArray;
import static org.junit.Assert.*;

public class ArrayUtilTest {

    @Test
    public void testIsStringInArray() {
        assertFalse(isStringInArray("randomString", "string", "that", "is splitted", "to an array"));
        assertFalse(isStringInArray("randomString"));
        assertTrue(isStringInArray("randomString","string that", "is splitted", "randomString"));
        assertTrue(isStringInArray("randomString","hello world", "randomString", "randomString"));
    }
}