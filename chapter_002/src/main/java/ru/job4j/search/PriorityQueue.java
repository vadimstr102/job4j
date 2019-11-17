package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            int index = 0;
            for (Task t: tasks) {
                if (task.getPriority() <= t.getPriority()) {
                    break;
                } else {
                    index++;
                }
            }
            tasks.add(index, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
