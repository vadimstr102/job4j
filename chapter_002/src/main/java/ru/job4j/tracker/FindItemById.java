package ru.job4j.tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Store store) {
        String id = input.askStr("Enter searched item id: ");
        Item item = store.findById(id);
        if (item != null) {
            System.out.println(item.getId() + " " + item.getName());
        } else {
            System.out.println("Item with this Id were not found");
        }
        return true;
    }
}
