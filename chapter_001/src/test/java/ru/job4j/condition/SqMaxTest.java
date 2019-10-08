package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void firstMax() {
        int result = SqMax.max(4, 3, 2, 1);
        assertThat(result, is(4));
    }
    @Test
    public void secondMax() {
        int result = SqMax.max(3, 4, 2, 1);
        assertThat(result, is(4));
    }
    @Test
    public void thirdMax() {
        int result = SqMax.max(2, 3, 4, 1);
        assertThat(result, is(4));
    }
    @Test
    public void fourMax() {
        int result = SqMax.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }
    @Test
    public void allMax() {
        int result = SqMax.max(4, 4, 4, 4);
        assertThat(result, is(4));
    }
    @Test
    public void twoMax() {
        int result = SqMax.max(1, 2, 3, 3);
        assertThat(result, is(3));
    }
}
