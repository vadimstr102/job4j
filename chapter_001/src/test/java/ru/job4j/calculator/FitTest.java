package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {
    @Test
    public void manWeight() {
        double in = 175;
        double expected = 86.25;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
    @Test
    public void womanWeight() {
        double in = 167;
        double expected = 65.55;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
