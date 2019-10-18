package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        Point c = new Point(5, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 12.5;
        Assert.assertEquals(expected, result, 0.01);
    }
    @Test
    public void whenNoExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        Point c = new Point(0, 6);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        Assert.assertEquals(expected, result, 0.01);
    }
}
