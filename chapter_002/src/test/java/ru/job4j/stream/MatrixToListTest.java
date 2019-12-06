package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class MatrixToListTest {
    MatrixToList matrix = new MatrixToList();
    Integer[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    @Test
    public void whenMatrixToList() {
        List<Integer> result = matrix.matrixToList(array);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertThat(result, is(expected));
    }
}
