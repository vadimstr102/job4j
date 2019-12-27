package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> pushStack = new SimpleStack<>();
    private SimpleStack<T> pollStack = new SimpleStack<>();

    public void push(T value) {
        this.pushStack.push(value);
    }

    public T poll() {
        if (pollStack.getSize() == 0) {
            while (pushStack.getSize() > 0) {
                this.pollStack.push(this.pushStack.poll());
            }
        }
        return this.pollStack.poll();
    }
}
