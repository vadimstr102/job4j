package ru.job4j.map;

import java.util.*;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return children == user.children
                    && Objects.equals(name, user.name)
                    && Objects.equals(birthday, user.birthday);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, children, birthday);
        }
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 1, new GregorianCalendar(1980, Calendar.JANUARY, 1));
        User user2 = new User("Ivan", 1, new GregorianCalendar(1980, Calendar.JANUARY, 1));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.hashCode() == user2.hashCode());
        System.out.println(user1.equals(user2));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
    }
}
