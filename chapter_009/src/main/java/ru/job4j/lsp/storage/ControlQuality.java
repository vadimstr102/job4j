package ru.job4j.lsp.storage;

import java.util.List;

public class ControlQuality {
    private final List<Store> list;

    public ControlQuality(List<Store> list) {
        this.list = list;
    }

    public void loadFood(Food food) {
        for (Store store : list) {
            store.add(food);
        }
    }
}
