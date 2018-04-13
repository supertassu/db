package me.tassu.db.sql.util;

import java.util.Arrays;

/**
 * Utility for working with {@link String[]}s.
 * @author tassu
 */
public class ArrayUtil {

    public static boolean isStringInArray(String string, String... array) {
        return Arrays.stream(array).anyMatch(it -> it.equalsIgnoreCase(string));
    }

}
