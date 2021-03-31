package ru.job4j.lsp.parking;

public class Automobile implements Car {
    private final int size;

    public Automobile(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
