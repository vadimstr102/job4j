package ru.job4j.tracker;

import java.util.List;

public class ShowAllItems extends BaseAction {

    public ShowAllItems(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Store store) {
        List<Item> items = store.findAll();
        if (items.size() != 0) {
            for (Item item: items) {
                System.out.println(item.getId() + " " + item.getName());
            }
        } else {
            System.out.println("Tracker is empty");
        }
        return true;
    }
}
