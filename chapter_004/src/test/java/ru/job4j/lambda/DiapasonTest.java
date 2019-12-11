package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    Diapason function = new Diapason();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadsFunctionThenQuadsResults() {
        List<Double> result = function.diapason(2, 8, x -> x * x);
        List<Double> expected = List.of(4D, 9D, 16D, 25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmFunctionThenLogarithmResults() {
        List<Double> result = new ArrayList<>();
        result.addAll(function.diapason(10, 11, x -> Math.log10(x)));
        result.addAll(function.diapason(100, 101, x -> Math.log10(x)));
        result.addAll(function.diapason(1000, 1001, x -> Math.log10(x)));
        List<Double> expected = Arrays.asList(1D, 2D, 3D);
        assertThat(result, is(expected));
    }
}
