package ru.job4j.lsp.parking;

import java.util.List;

public class CarParking implements Parking {
    private int countAutomobile;
    private int countTruck;
    private final List<Car> cars;

    public CarParking(int countAutomobile, int countTruck, List<Car> cars) {
        this.countAutomobile = countAutomobile;
        this.countTruck = countTruck;
        this.cars = cars;
    }

    @Override
    public boolean park(Car car) {
        return true;
    }

    @Override
    public boolean delete(Car car) {
        return true;
    }

    @Override
    public boolean accept(Car car) {
        return true;
    }
}
