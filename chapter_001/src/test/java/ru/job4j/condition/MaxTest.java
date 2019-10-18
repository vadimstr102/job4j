package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax3To2Then() {
        int result = Max.max(3, 2);
        assertThat(result, is(3));
    }
    @Test
    public void whenMax2To2Then() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax123Then() {
        assertThat(
                Max.max(1, 2, 3),
                is(3)
        );
    }

    @Test
    public void whenMax1234Then() {
        assertThat(
                Max.max(1, 2, 3, 4),
                is(4)
        );
    }
}
