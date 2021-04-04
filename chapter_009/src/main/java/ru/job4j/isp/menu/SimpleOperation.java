package ru.job4j.isp.menu;

public class SimpleOperation implements Operation {
    @Override
    public void execute() {
        System.out.println("-----Operation accept-----");
    }
}
