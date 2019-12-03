package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DepartureTest {
    Set<String> list = new HashSet<>();

    @Before
    public void start() {
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
    }

    @Test
    public void whenFillGapsAndAbs() {
        list = Departure.fillGaps(list);
        Departure.abs(list);
        Assert.assertEquals(list.toString(), "[K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2, K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2]");
    }

    @Test
    public void whenFillGapsAndDesc() {
        list = Departure.fillGaps(list);
        list = Departure.desc(list);
        Assert.assertEquals(list.toString(), "[K2, K2\\SK1, K2\\SK1\\SSK2, K2\\SK1\\SSK1, K1, K1\\SK2, K1\\SK1, K1\\SK1\\SSK2, K1\\SK1\\SSK1]");
    }
}
