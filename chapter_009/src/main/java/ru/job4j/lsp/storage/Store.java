package ru.job4j.lsp.storage;

import java.util.List;

public interface Store {
    boolean accept(Food food);

    void add(Food food);

    List<Food> getList();
}
