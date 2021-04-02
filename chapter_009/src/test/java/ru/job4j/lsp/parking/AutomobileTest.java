package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class AutomobileTest {

    @Test
    public void whenGetSize() {
        Car automobile = new Automobile();
        Assert.assertThat(automobile.size(), is(1));
    }
}
