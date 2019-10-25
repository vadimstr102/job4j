package ru.job4j.tracker;



public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item created");
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                if (items.length != 0) {
                    for (Item item: items) {
                        System.out.println(item.getId() + " " + item.getName());
                    }
                } else {
                    System.out.println("Tracker is empty");
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ====");
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
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                String id = input.askStr("Enter deleted item id: ");
                boolean result = tracker.delete(id);
                if (result) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item with this Id were not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                String id = input.askStr("Enter searched item id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.getId() + " " + item.getName());
                } else {
                    System.out.println("Item with this Id were not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String name = input.askStr("Enter searched item name: ");
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    for (Item item: items) {
                        System.out.println(item.getId() + " " + item.getName());
                    }
                } else {
                    System.out.println("Items with this name were not found");
                }
            } else if (select == 6) {
                System.out.println("Exit program...");
                run = false;
            } else {
                System.out.println("Enter a correct number, please");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
