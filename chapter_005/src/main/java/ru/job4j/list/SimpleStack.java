package ru.job4j.list;

public class SimpleStack<T> {
    private LinkedListContainer<T> linkedListContainer = new LinkedListContainer<>();

    public T poll() {
        return linkedListContainer.delete();
    }

    public void push(T value) {
        linkedListContainer.add(value);
    }

    public int getSize() {
        return this.linkedListContainer.getSize();
    }
}
