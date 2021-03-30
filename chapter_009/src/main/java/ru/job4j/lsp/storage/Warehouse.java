package ru.job4j.lsp.storage;

import java.util.List;

public class Warehouse implements Store {

    private final List<Food> list;

    public Warehouse(List<Food> list) {
        this.list = list;
    }

    @Override
    public boolean accept(Food food) {
        return food.getQuality() < 25;
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
