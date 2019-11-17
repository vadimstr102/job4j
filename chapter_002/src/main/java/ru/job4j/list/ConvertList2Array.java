package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
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
}
