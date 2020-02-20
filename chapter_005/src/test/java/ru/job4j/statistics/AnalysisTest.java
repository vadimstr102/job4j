package ru.job4j.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalysisTest {
    Analysis analysis = new Analysis();
    List<Analysis.User> previous = new ArrayList<>();
    List<Analysis.User> current = new ArrayList<>();

    @Before
    public void start() {
        previous.add(new Analysis.User(123, "Ivan"));
        previous.add(new Analysis.User(456, "Petr"));
        previous.add(new Analysis.User(789, "Nick"));

        current.add(new Analysis.User(123, "Ivan"));
        current.add(new Analysis.User(121, "Sam"));
        current.add(new Analysis.User(456, "Ken"));
        current.add(new Analysis.User(666, "Nick"));
        current.add(new Analysis.User(777, "Petr"));
    }

    @Test
    public void whenUseDiffUsers() {
        Analysis.Info info = analysis.diff(previous, current);
        assertThat(info.added, is(3));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }
}
