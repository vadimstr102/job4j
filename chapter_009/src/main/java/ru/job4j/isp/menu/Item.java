package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Item implements Node<Item>, Operation {
    private final String id;
    private final Operation operation;
    private final List<Item> childNodes;

    public Item(String id, Operation operation) {
        this.id = id;
        this.operation = operation;
        childNodes = new ArrayList<>();
    }

    public String getID() {
        return id;
    }

    @Override
    public List<Item> getChildNodes() {
        return childNodes;
    }

    @Override
    public void execute() {
        System.out.println("Item " + id + " execute operation...");
        operation.execute();
    }
}
