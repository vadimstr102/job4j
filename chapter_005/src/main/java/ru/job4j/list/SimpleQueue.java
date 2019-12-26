package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> simpleStack1 = new SimpleStack<>();
    private SimpleStack<T> simpleStack2 = new SimpleStack<>();
    private int count1 = 0;
    private int count2 = 0;

    public T poll() {
        while (count1 > 0) {
            this.simpleStack2.push(this.simpleStack1.poll());
            this.count2++;
            this.count1--;
        }
        this.count2--;
        return this.simpleStack2.poll();
    }

    public void push(T value) {
        while (count2 > 0) {
            this.simpleStack1.push(this.simpleStack2.poll());
            this.count1++;
            this.count2--;
        }
        this.count1++;
        this.simpleStack1.push(value);
    }
}
