package ru.job4j.tracker.singleton;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.singletone.TrackerSingle1;

import static org.hamcrest.core.Is.is;

public class TrackerSingle1Test {
    @Test
    public void whenCreateObjects() {
        TrackerSingle1 ts1 = TrackerSingle1.INSTANCE;
        TrackerSingle1 ts2 = TrackerSingle1.INSTANCE;
        Assert.assertThat(ts1, is(ts2));
    }
}
