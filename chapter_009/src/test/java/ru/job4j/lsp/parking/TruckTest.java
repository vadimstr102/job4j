package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class TruckTest {

    @Test
    public void whenGetSize() {
        Car truck = new Truck(5);
        Assert.assertThat(truck.size(), is(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSetWrongSize() {
        Car truck = new Truck(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSetNegativeSize() {
        Car truck = new Truck(-7);
    }
}
