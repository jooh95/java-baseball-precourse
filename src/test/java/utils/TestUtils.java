package utils;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    private TestUtils() {
    }

    public static List<Integer> toList(String str) {
        List<Integer> integers = new ArrayList<>();
        for (char c : str.toCharArray()) {
            integers.add(Character.getNumericValue(c));
        }
        return integers;
    }
}
