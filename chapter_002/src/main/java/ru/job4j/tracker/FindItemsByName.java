package ru.job4j.tracker;

public class FindItemsByName implements  UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter searched item name: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item: items) {
                System.out.println(item.getId() + " " + item.getName());
            }
        } else {
            System.out.println("Items with this name were not found");
        }
        return true;
    }
}
