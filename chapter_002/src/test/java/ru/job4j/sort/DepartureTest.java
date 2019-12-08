package ru.job4j.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class DepartureTest {
    Set<String> list = Set.of(
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
    );

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
