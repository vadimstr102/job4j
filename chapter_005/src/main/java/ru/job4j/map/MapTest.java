package ru.job4j.map;

import java.util.Calendar;

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
    }
}
