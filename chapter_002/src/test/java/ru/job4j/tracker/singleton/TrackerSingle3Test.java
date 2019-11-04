package ru.job4j.tracker.singleton;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.singletone.TrackerSingle3;

import static org.hamcrest.core.Is.is;

public class TrackerSingle3Test {
    @Test
    public void whenCreateObjects() {
        TrackerSingle3 ts1 = TrackerSingle3.getInstance();
        TrackerSingle3 ts2 = TrackerSingle3.getInstance();
        Assert.assertThat(ts1, is(ts2));
    }
}
