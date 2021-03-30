package ru.job4j.lsp.storage;

import java.util.List;

public class Trash implements Store {

    private final List<Food> list;

    public Trash(List<Food> list) {
        this.list = list;
    }

    @Override
    public boolean accept(Food food) {
        return food.getQuality() >= 100;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            list.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}
