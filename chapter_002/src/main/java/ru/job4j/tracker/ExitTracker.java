package ru.job4j.tracker;

public class ExitTracker extends BaseAction {

    public ExitTracker(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Exit...");
        return false;
    }
}
