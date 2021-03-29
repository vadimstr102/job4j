package ru.job4j.lsp.storage;

import java.util.List;

public class Shop implements Storage {
    private List<Food> list;

    public Shop(List<Food> list) {
        this.list = list;
    }

    @Override
    public void add(Food food) {
        list.add(food);
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}
