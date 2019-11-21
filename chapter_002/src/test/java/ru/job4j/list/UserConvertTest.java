package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class UserConvertTest {
    @Test
    public void whenUserConvert() {
        User user1 = new User(666, "Vadim", "Novosibirsk");
        User user2 = new User(777, "Ivan", "Moscow");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        HashMap<Integer, User> result = new UserConvert().process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(666, user1);
        expect.put(777, user2);
        Assert.assertEquals(result, expect);
    }
}
