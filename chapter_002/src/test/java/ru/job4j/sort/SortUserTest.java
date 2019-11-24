package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SortUserTest {
    @Test
    public void whenSortByAge() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vadim", 30));
        users.add(new User("Petr", 25));
        users.add(new User("Ivan", 35));
        users.add(new User("Alex", 18));
        Set<User> result = new SortUser().sort(users);
        Assert.assertEquals(result.toString(), "[Alex: 18, Petr: 25, Vadim: 30, Ivan: 35]");
    }

    @Test
    public void whenSortByNameLength() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vadim", 30));
        users.add(new User("Petr", 25));
        users.add(new User("Alexandr", 18));
        users.add(new User("Cat", 35));
        users = new SortUser().sortNameLength(users);
        Assert.assertEquals(users.toString(), "[Cat: 35, Petr: 25, Vadim: 30, Alexandr: 18]");
    }

    @Test
    public void whenSortByAllFields() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vadim", 25));
        users.add(new User("Petr", 30));
        users.add(new User("Vadim", 20));
        users.add(new User("Petr", 25));
        users = new SortUser().sortByAllFields(users);
        Assert.assertEquals(users.toString(), "[Petr: 25, Petr: 30, Vadim: 20, Vadim: 25]");
    }
}
