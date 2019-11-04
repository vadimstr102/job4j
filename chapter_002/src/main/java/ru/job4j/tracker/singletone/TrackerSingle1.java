package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Item;

public enum TrackerSingle1 {
    INSTANCE; // здесь мы указываем перечисления.

    // Конструкторы и методы.
    public Item add(Item model) {
        return model;
    }
}
