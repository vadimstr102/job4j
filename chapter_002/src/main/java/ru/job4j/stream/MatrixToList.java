package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {

    public List<Integer> matrixToList(Integer[][] array) {
        List<Integer> result = Arrays.stream(array).flatMap(Arrays::stream).collect(Collectors.toList());
        return result;
    }
}
