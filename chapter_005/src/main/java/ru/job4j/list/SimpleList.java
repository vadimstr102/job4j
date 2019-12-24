package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E> implements Iterable<E> {
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public SimpleList() {
        this.container = new Object[10];
    }

    public void add(E value) {
        if (this.index == this.container.length) {
            Object[] newContainer = new Object[this.index * 2];
            System.arraycopy(this.container, 0, newContainer, 0, this.index);
            this.container = newContainer;
            this.modCount++;
        }
        this.container[index++] = value;
    }

    public E get(int position) {
        return (E) this.container[position];
    }

    public int size() {
        return this.container.length;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
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
        return it;
    }
}
