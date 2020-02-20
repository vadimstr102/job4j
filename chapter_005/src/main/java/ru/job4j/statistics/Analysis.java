package ru.job4j.statistics;

import java.util.List;
import java.util.Objects;

public class Analysis {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        for (User user : current) {
            if (previous.contains(user)) {
                String userName = previous.get(previous.indexOf(user)).name;
                if (!user.name.equals(userName)) {
                    info.changed++;
                }
            } else {
                info.added++;
            }
        }
        for (User user : previous) {
            if (!current.contains(user)) {
                info.deleted++;
            }
        }
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
