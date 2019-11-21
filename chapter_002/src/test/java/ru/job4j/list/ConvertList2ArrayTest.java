package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5});
        list.add(new int[]{6, 7, 8, 9});
        List<Integer> result = new ConvertList2Array().convert(list);
        assertThat(result.toString(), is("[1, 2, 3, 4, 5, 6, 7, 8, 9]"));
    }
}