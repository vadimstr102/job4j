package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analysis {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> currentMap = new HashMap<>();
        for (User user : current) {
            currentMap.put(user.id, user);
        }
        for (User user : previous) {
            if (currentMap.containsKey(user.id)) {
                if (!currentMap.get(user.id).equals(user)) {
                    info.changed++;
                }
            } else {
                info.deleted++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
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
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
