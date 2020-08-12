package ru.job4j.exam;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        for (String s : left.split("")) {
            right = right.replaceFirst(s, "");
        }
        return right.length() == 0;
    }
}
