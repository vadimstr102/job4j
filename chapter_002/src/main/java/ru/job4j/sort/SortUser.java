package ru.job4j.sort;

import java.util.*;

public class SortUser {

    public Set<User> sortAge(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> result = new ArrayList<>(list);
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        List<User> result = new ArrayList<>(list);
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : result;
            }
        });
        return result;
    }
}
