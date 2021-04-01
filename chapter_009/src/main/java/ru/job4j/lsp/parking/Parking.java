package ru.job4j.lsp.parking;

public interface Parking {
    boolean accept(Car car);

    boolean park(Car car);

    boolean delete(Car car);
}
