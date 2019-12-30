package ru.job4j.set;

import ru.job4j.list.ArrayListContainer;

import java.util.Iterator;

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
        if (value == null) {
            if (this.list.get(this.list.size() - 1) == null) {
                result = false;
            }
        } else {
            for (E e : this.list) {
                if (value.equals(e)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
