package ru.job4j.exam;

import java.util.HashMap;

/**
 * @author Vadim Timofeev
 */
public class FreezeStr {
    /**
     * The method checks that the second line was obtained
     * by rearranging the characters of the first line
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        HashMap<String, Integer> leftMap = new HashMap<>();
        HashMap<String, Integer> rightMap = new HashMap<>();
        fillMap(leftMap, left.toLowerCase());
        fillMap(rightMap, right.toLowerCase());
        return leftMap.equals(rightMap);
    }

    /**
     * Method fills the map.
     * key - string (@param line) character
     * value - the number of occurrences of a character in a string
     *
     * @param map
     * @param line
     */
    private static void fillMap(HashMap<String, Integer> map, String line) {
        for (String s : line.split("")) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, ++count);
            } else {
                map.put(s, 1);
            }
        }
    }
}
