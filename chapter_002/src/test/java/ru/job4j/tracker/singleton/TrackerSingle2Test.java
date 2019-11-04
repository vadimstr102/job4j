package ru.job4j.tracker.singleton;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.singletone.TrackerSingle2;

import static org.hamcrest.core.Is.is;


public class TrackerSingle2Test {
    @Test
    public void whenCreateObjects() {
        TrackerSingle2 ts1 = TrackerSingle2.getInstance();
        TrackerSingle2 ts2 = TrackerSingle2.getInstance();
        Assert.assertThat(ts1, is(ts2));
    }
}
