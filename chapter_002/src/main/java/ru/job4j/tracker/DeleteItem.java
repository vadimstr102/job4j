package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
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
