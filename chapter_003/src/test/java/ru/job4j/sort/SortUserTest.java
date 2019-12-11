package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class SortUserTest {
    SortUser sortUser = new SortUser();

    @Test
    public void whenSortByAge() {
        List<User> users = List.of(
                new User("Vadim", 30),
                new User("Petr", 25),
                new User("Ivan", 35),
                new User("Alex", 18)
        );
        Set<User> result = sortUser.sortAge(users);
        Assert.assertEquals(result.toString(), "[Alex: 18, Petr: 25, Vadim: 30, Ivan: 35]");
    }

    @Test
    public void whenSortByNameLength() {
        List<User> users = List.of(
                new User("Vadim", 30),
                new User("Petr", 25),
                new User("Alexandr", 18),
                new User("Cat", 35)
        );
        users = sortUser.sortNameLength(users);
        Assert.assertEquals(users.toString(), "[Cat: 35, Petr: 25, Vadim: 30, Alexandr: 18]");
    }

    @Test
    public void whenSortByAllFields() {
        List<User> users = List.of(
                new User("Vadim", 25),
                new User("Petr", 30),
                new User("Vadim", 20),
                new User("Petr", 25)
        );
        users = sortUser.sortByAllFields(users);
        Assert.assertEquals(users.toString(), "[Petr: 25, Petr: 30, Vadim: 20, Vadim: 25]");
    }
}
