package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        int in1 = 0, in2 = 0, in3 = 2, in4 = 0;
        double expected = 2.0;
        double out = Point.distance(in1, in2, in3, in4);
        Assert.assertEquals(expected, out, 0.01);
    }
}
