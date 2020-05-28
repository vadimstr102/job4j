package ru.job4j.tracker;

import java.util.List;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Store store) {
        String name = input.askStr("Enter searched item name: ");
        List<Item> items = store.findByName(name);
        if (items.size() != 0) {
            for (Item item: items) {
                System.out.println(item.getId() + " " + item.getName());
            }
        } else {
            System.out.println("Items with this name were not found");
        }
        return true;
    }
}
