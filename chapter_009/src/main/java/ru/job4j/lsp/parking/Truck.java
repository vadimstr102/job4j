package ru.job4j.lsp.parking;

public class Truck implements Car {
    private final int size;

    public Truck(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Truck size must be more then 1!");
        }
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
