package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MinTest {
    @Test
    public void whenFirstMin() {
        int[] array = new int[] {1, 6, 2, 4, 3, 9, 5};
        int result = Min.findMin(array);
        assertThat(result, is(1));
    }

    @Test
    public void whenLastMin() {
        int[] array = new int[] {10, 6, 5, 4, 3, 9, 2};
        int result = Min.findMin(array);
        assertThat(result, is(2));
    }

    @Test
    public void whenMiddleMin() {
        int[] array = new int[] {5, 6, 7, 3, 4, 9, 5};
        int result = Min.findMin(array);
        assertThat(result, is(3));
    }
}
