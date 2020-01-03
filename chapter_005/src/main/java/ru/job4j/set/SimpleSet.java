package ru.job4j.set;

import ru.job4j.list.ArrayListContainer;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private ArrayListContainer<E> list = new ArrayListContainer<>();

    public boolean add(E value) {
        boolean result = duplicateCheck(value);
        if (result) {
            this.list.add(value);
        }
        return result;
    }

    private boolean duplicateCheck(E value) {
        boolean result = true;
        for (E e : this.list) {
            if (Objects.equals(value, e)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
