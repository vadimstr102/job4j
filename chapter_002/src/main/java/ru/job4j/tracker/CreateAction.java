package ru.job4j.tracker;

public class CreateAction extends BaseAction {

    public CreateAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Store store) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        store.add(item);
        System.out.println("Item added");
        return true;
    }
}
