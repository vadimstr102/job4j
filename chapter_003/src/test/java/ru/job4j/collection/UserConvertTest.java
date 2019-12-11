package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class UserConvertTest {
    @Test
    public void whenUserConvert() {
        User user1 = new User(666, "Vadim", "Novosibirsk");
        User user2 = new User(777, "Ivan", "Moscow");
        List<User> list = List.of(
                user1, user2
        );
        Map<Integer, User> result = new UserConvert().process(list);
        Map<Integer, User> expect = Map.of(
                666, user1,
                777, user2
        );
        Assert.assertEquals(result, expect);
    }
}
