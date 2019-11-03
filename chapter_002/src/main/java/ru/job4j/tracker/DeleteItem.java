package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter deleted item id: ");
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Item with this Id were not found");
        }
        return true;
    }
}
