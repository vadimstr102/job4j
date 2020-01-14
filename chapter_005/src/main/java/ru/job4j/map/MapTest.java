package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    private static class User {
        private String name;
        private int children;
        private Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "{" + this.name + "}";
        }
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 1, new GregorianCalendar(1980, Calendar.JANUARY, 1));
        User user2 = new User("Ivan", 1, new GregorianCalendar(1980, Calendar.JANUARY, 1));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
    }
}
