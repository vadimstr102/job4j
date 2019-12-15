package ru.job4j.iterator;

import java.util.Iterator;

public class TwoDimensionalArrayIterator implements Iterator {
    private final int[][] values;
    private int index1 = 0;
    private int index2 = 0;

    public TwoDimensionalArrayIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (index1 == values.length - 1 && index2 == values[index1].length) {
            result = false;
        }
        return result;
    }

    @Override
    public Object next() {
        if (index2 == values[index1].length) {
            index1++;
            index2 = 0;
        }
        return values[index1][index2++];
    }
}
