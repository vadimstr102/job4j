package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int rowIndex = 0;
        int cellIndex = 0;
        for (Integer num: list) {
            array[rowIndex][cellIndex] = num;
            cellIndex++;
            if (cellIndex == cells) {
                cellIndex = 0;
                rowIndex++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array: list) {
            for (int num: array) {
                result.add(num);
            }
        }
        return result;
    }
}
