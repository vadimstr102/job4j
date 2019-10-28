package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter edited item id: ");
        String name = input.askStr("Enter new item name: ");
        Item item = new Item(name);
        item.setId(id);
        boolean result = tracker.replace(id, item);
        if (result) {
            System.out.println("Item edited");
        } else {
            System.out.println("Item with this Id were not found");
        }
        return true;
    }
}
