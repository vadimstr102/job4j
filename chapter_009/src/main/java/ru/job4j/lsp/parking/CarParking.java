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
        if (accept(car)) {
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Car car) {
        if (cars.remove(car)) {
            if (car.size() == 1) {
                countAutomobile++;
            } else {
                countTruck += car.size();
            }
        }
    }

    @Override
    public boolean accept(Car car) {
        if (car.size() == 1) {
            if (--countAutomobile >= 0) {
                return true;
            }
            countAutomobile = 0;
        } else if (car.size() > 1) {
            countTruck -= car.size();
            if (countTruck >= 0) {
                return true;
            }
            countTruck = 0;
        }
        return false;
    }
}
