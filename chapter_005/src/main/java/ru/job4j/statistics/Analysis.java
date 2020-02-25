package ru.job4j.statistics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Analysis {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Set<User> previousSet = new HashSet<>(previous);
        Set<User> currentSet = new HashSet<>(current);
        for (User user : currentSet) {
            if (previousSet.contains(user)) {
                String userName = previous.get(previous.indexOf(user)).name;
                if (!user.name.equals(userName)) {
                    info.changed++;
                }
            } else {
                info.added++;
            }
        }
        for (User user : previousSet) {
            if (!currentSet.contains(user)) {
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
