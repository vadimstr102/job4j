package ru.job4j.sort;

import java.util.*;

public class Departure {

    public static Set<String> abs(Set<String> orgs) {
        return new TreeSet<>(orgs);
    }

    public static Set<String> desc(Set<String> orgs) {
        Set<String> result = new TreeSet<>((o1, o2) -> {
            int res = o2.compareTo(o1);
            if (res != 0) {
                if (o1.indexOf(o2) == 0) {
                    res = 1;
                }
                if (o2.indexOf(o1) == 0) {
                    res = -1;
                }
            }
            return res;
        });
        result.addAll(orgs);
        return result;
    }

    public static Set<String> fillGaps(Set<String> orgs) {
        Set<String> result = new TreeSet<>(orgs);
        for (String s : orgs) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '\\') {
                    String department = s.substring(0, j);
                    if (!orgs.contains(department)) {
                        result.add(department);
                    }
                }
            }
        }
        return result;
    }
}
