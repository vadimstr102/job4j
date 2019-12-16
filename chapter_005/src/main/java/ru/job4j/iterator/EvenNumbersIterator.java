package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int index = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (index == values.length || values[index] % 2 != 0) {
            result = false;
            while (index < values.length) {
                if (values[index] % 2 == 0) {
                    result = true;
                    break;
                }
                index++;
            }
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}
