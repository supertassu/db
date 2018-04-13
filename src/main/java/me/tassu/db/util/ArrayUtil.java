package me.tassu.db.util;

import java.util.Arrays;

/**
 * Utility for working with {@link String[]}s.
 * @author tassu
 */
public class ArrayUtil {

    /**
     * tests if specified string is in given array
     * @param string string to test
     * @param array array to test to
     * @return was the string in the array
     */
    public static boolean isStringInArray(String string, String... array) {
        return Arrays.stream(array).anyMatch(it -> it.equalsIgnoreCase(string));
    }

}
