package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class UserStoreTest {
    User user1 = new User("u1");
    User user2 = new User("u2");
    User user3 = new User("u3");
    User user4 = new User("u4");
    User user5 = new User("u5");
    UserStore userStore = new UserStore(10);

    @Before
    public void start() {
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        userStore.add(user4);
        userStore.add(user5);
    }

    @Test
    public void whenGetIndex() {
        int result = userStore.getIndex("u4");
        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenIndexNotFind() {
        int result = userStore.getIndex("u6");
        Assert.assertThat(result, is(-1));
    }

    @Test
    public void whenReplaceUser() {
        User userX = new User("uX");
        boolean result = userStore.replace("u3", userX);
        Assert.assertThat(result, is(true));
        Assert.assertThat(userStore.getIndex("uX"), is(2));
    }

    @Test
    public void whenDeleteUser() {
        boolean result = userStore.delete("u5");
        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenFindById() {
        User result = userStore.findById("u2");
        Assert.assertThat(result.getId(), is("u2"));
    }
}
