package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        this.array[index++] = model;
    }

    public void set(int position, T model) {
        this.array[position] = model;
    }

    public void remove(int position) {
        this.array[position] = null;
        if (position != this.array.length - 1) {
            System.arraycopy(this.array, position + 1, this.array, position, this.array.length - position - 1);
            this.array[this.array.length - 1] = null;
        }
    }

    public T get(int position) {
        return (T) this.array[position];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = true;
                if (index == array.length) {
                    result = false;
                }
                return result;
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index++];
            }
        };
        return iterator;
    }
}
