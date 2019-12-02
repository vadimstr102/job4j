package ru.job4j.sort;

import java.util.*;

public class Departure {
    public static void abs(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static List<String> desc(List<String> orgs) {
        orgs.sort(Comparator.reverseOrder());
        List<String> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < orgs.size() - 1; i++) {
            if (orgs.get(i).split("\\\\")[0].equals(orgs.get(i + 1).split("\\\\")[0])) {
                temp.add(orgs.get(i));
            } else {
                temp.add(orgs.get(i));
                Collections.reverse(temp);
                sort(temp);
                list.addAll(temp);
                temp.clear();
            }
            if (i == orgs.size() - 2) {
                temp.add(orgs.get(i + 1));
                Collections.reverse(temp);
                sort(temp);
                list.addAll(temp);
                temp.clear();
            }
        }
        return list;
    }

    private static void sort(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result;
                int length1 = o1.split("\\\\").length;
                int length2 = o2.split("\\\\").length;
                if (length1 < length2) {
                    result = o2.split("\\\\")[length1 - 1].compareTo(o1.split("\\\\")[length1 - 1]);
                } else {
                    result = o2.split("\\\\")[length2 - 1].compareTo(o1.split("\\\\")[length2 - 1]);
                }
                return result;
            }
        });
    }

    public static List<String> fillGaps(List<String> orgs) {
        List<String> list = new ArrayList<>(orgs);
        for (int i = 0; i < orgs.size(); i++) {
            String s = orgs.get(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '\\') {
                    String department = s.substring(0, j);
                    if (!list.contains(department)) {
                        list.add(department);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        list = Departure.fillGaps(list);
        list = Departure.desc(list);
        System.out.println(list);
    }
}
