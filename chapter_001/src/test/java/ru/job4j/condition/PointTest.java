package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance() {
        Point a = new Point(4, 0);
        Point b = new Point(9, 0);
        double out = a.distance(b);
        double expected = 5.0;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3D() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 10);
        double out = a.distance3d(b);
        double expected = 10.0;
        Assert.assertEquals(expected, out, 0.01);
    }
}
