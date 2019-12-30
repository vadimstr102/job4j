package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListContainer<E> implements Iterable<E> {
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public ArrayListContainer() {
        this.container = new Object[10];
    }

    public void add(E value) {
        if (this.index == this.container.length) {
            containerExpansion();
        }
        this.container[index++] = value;
    }

    private void containerExpansion() {
        Object[] newContainer = new Object[this.index * 2];
        System.arraycopy(this.container, 0, newContainer, 0, this.index);
        this.container = newContainer;
        this.modCount++;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    public int size() {
        return this.index;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int itIndex = 0;
            private int itModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.itModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (itIndex < container.length && container[itIndex] == null) {
                    itIndex++;
                }
                return itIndex < container.length && container[itIndex] != null;
            }

            @Override
            public E next() {
                if (this.itModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[itIndex++];
            }
        };
    }
}
