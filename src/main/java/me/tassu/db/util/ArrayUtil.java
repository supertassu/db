package me.tassu.db.util;

import java.util.Arrays;

public class ArrayUtil {

    public static boolean isStringInArray(String string, String... array) {
        return Arrays.stream(array).anyMatch(it -> it.equalsIgnoreCase(string));
    }

}
