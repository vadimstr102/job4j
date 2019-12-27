package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Метод удаления первого элемента в списке.
     */
    public E delete() {
        Node<E> result = this.first;
        this.first = result.next;
        this.size--;
        return result.data;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int itIndex;
            private int itModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.itModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.itIndex < size;
            }

            @Override
            public E next() {
                if (this.itModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(itIndex++);
            }
        };
    }
}
