package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (UserAction action: actions) {
            System.out.println(action.info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(7);
        actions.add(new CreateAction(0, "Add new item"));
        actions.add(new ReplaceItem(1, "Edit item"));
        actions.add(new DeleteItem(2, "Delete item"));
        actions.add(new ShowAllItems(3, "Show all items"));
        actions.add(new FindItemById(4, "Find item by Id"));
        actions.add(new FindItemsByName(5, "Find items by name"));
        actions.add(new ExitTracker(6, "Exit"));
        new StartUI().init(validate, tracker, actions);
    }
}
