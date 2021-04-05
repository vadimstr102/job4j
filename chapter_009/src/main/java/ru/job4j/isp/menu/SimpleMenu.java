package ru.job4j.isp.menu;

import java.util.List;
import java.util.Scanner;

public class SimpleMenu implements Menu<Item> {
    private final String nameItem = "Task ";
    private String indent = "";
    private final String addIndent = "----";

    @Override
    public void startMenu(List<Item> items) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Menu:");
            showMenu(items);
            System.out.println("Enter task ID or \"exit\": ");
            input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            executeItem(items, input);
            System.out.println();
        }
        scanner.close();
    }

    private void showMenu(List<Item> items) {
        for (Item item : items) {
            System.out.println(indent + nameItem + item.getID());
            if (item.getChildNodes().size() > 0) {
                indent = indent.concat(addIndent);
                showMenu(item.getChildNodes());
                indent = indent.replaceFirst(addIndent, "");
            }
        }
    }

    private void executeItem(List<Item> items, String id) {
        for (Item item : items) {
            if (item.getID().equals(id)) {
                item.execute();
                break;
            } else if (item.getChildNodes().size() > 0) {
                executeItem(item.getChildNodes(), id);
            }
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item("1", new SimpleOperation());
        Item item11 = new Item("1.1", new SimpleOperation());
        Item item12 = new Item("1.2", new SimpleOperation());
        Item item13 = new Item("1.3", new SimpleOperation());
        Item item111 = new Item("1.1.1", new SimpleOperation());
        Item item121 = new Item("1.2.1", new SimpleOperation());
        Item item131 = new Item("1.3.1", new SimpleOperation());
        item1.getChildNodes().add(item11);
        item1.getChildNodes().add(item12);
        item1.getChildNodes().add(item13);
        item11.getChildNodes().add(item111);
        item12.getChildNodes().add(item121);
        item13.getChildNodes().add(item131);

        Item item2 = new Item("2", new SimpleOperation());
        Item item21 = new Item("2.1", new SimpleOperation());
        Item item22 = new Item("2.2", new SimpleOperation());
        Item item23 = new Item("2.3", new SimpleOperation());
        Item item211 = new Item("2.1.1", new SimpleOperation());
        Item item221 = new Item("2.2.1", new SimpleOperation());
        Item item231 = new Item("2.3.1", new SimpleOperation());
        item2.getChildNodes().add(item21);
        item2.getChildNodes().add(item22);
        item2.getChildNodes().add(item23);
        item21.getChildNodes().add(item211);
        item22.getChildNodes().add(item221);
        item23.getChildNodes().add(item231);

        SimpleMenu menu = new SimpleMenu();
        menu.startMenu(List.of(item1, item2));
    }
}
