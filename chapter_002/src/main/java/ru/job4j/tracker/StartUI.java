package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Store store;
    private final Consumer<String> output;

    public StartUI(Input input, Store store, Consumer<String> output) {
        this.input = input;
        this.store = store;
        this.output = output;
    }

    public void init(List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = this.input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(this.input, this.store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.accept("Menu.");
        for (UserAction action: actions) {
            output.accept(action.info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = new ArrayList<>(7);
            actions.add(new CreateAction(0, "Add new item"));
            actions.add(new ReplaceItem(1, "Edit item"));
            actions.add(new DeleteItem(2, "Delete item"));
            actions.add(new ShowAllItems(3, "Show all items"));
            actions.add(new FindItemById(4, "Find item by Id"));
            actions.add(new FindItemsByName(5, "Find items by name"));
            actions.add(new ExitTracker(6, "Exit"));
            new StartUI(validate, tracker, System.out::println).init(actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
