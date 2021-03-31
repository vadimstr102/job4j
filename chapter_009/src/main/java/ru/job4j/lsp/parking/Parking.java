package ru.job4j.lsp.parking;

public interface Parking {
    boolean park(Car car);

    void delete(Car car);

    boolean accept(Car car);
}
