package ru.job4j.tracker;

public class ReplaceItem extends BaseAction {

    public ReplaceItem(int key, String name) {
        super(key, name);
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
