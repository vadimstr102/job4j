package ru.job4j.tracker;

public class ExitTracker extends BaseAction {

    public ExitTracker(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Store store) {
        System.out.println("Exit...");
        try {
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
