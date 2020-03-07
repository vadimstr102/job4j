package ru.job4j.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    Analysis analysis = new Analysis();
    List<Analysis.User> previous = new ArrayList<>();
    List<Analysis.User> current = new ArrayList<>();
    Analysis.User user1 = new Analysis.User(123, "Ivan");
    Analysis.User user2 = new Analysis.User(456, "Petr");
    Analysis.User user3 = new Analysis.User(789, "Nick");
    Analysis.User changedUser1 = new Analysis.User(123, "Sam");
    Analysis.User changedUser2 = new Analysis.User(456, "Ken");
    Analysis.User changedUser3 = new Analysis.User(789, "Vladimir");
    Analysis.User newUser1 = new Analysis.User(230, "Ivan");
    Analysis.User newUser2 = new Analysis.User(560, "Petr");
    Analysis.User newUser3 = new Analysis.User(890, "Nick");

    @Test
    public void whenAddNewUsers() {
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        current.add(user1);
        current.add(user2);
        current.add(user3);
        current.add(newUser1);
        current.add(newUser2);
        current.add(newUser3);
        Analysis.Info info = analysis.diff(previous, current);
        assertThat(info.added, is(3));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenChangeUsers() {
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        current.add(changedUser1);
        current.add(changedUser2);
        current.add(changedUser3);
        Analysis.Info info = analysis.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(3));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenDeleteUsers() {
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        current.add(user1);
        Analysis.Info info = analysis.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(2));
    }

    @Test
    public void whenAddChangeDeleteUsers() {
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        current.add(changedUser2);
        current.add(changedUser3);
        current.add(newUser1);
        current.add(newUser2);
        current.add(newUser3);
        Analysis.Info info = analysis.diff(previous, current);
        assertThat(info.added, is(3));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(1));
    }
}
