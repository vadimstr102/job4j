package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int index = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < index; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = left.length() < right.length() ? -1 : 1;
        }
        return result;
    }
}
