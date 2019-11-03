package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (UserAction action: actions) {
            System.out.println(action.info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(0, "Add new item"),
                new ReplaceItem(1, "Edit item"),
                new DeleteItem(2, "Delete item"),
                new ShowAllItems(3, "Show all items"),
                new FindItemById(4, "Find item by Id"),
                new FindItemsByName(5, "Find items by name"),
                new ExitTracker(6, "Exit")
        };
        new StartUI().init(validate, tracker, actions);
    }
}
