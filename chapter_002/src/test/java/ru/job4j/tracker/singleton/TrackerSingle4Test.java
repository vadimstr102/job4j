package ru.job4j.tracker.singleton;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.singletone.TrackerSingle4;

import static org.hamcrest.core.Is.is;

public class TrackerSingle4Test {
    @Test
    public void whenCreateObjects() {
        TrackerSingle4 ts1 = TrackerSingle4.getInstance();
        TrackerSingle4 ts2 = TrackerSingle4.getInstance();
        Assert.assertThat(ts1, is(ts2));
    }
}
