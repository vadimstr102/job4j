package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    private int automobilePlace;
    private int truckPlace;
    private final List<Car> automobiles;
    private final List<Car> trucks;

    public CarParking(int automobilePlace, int truckPlace) {
        this.automobilePlace = automobilePlace;
        this.truckPlace = truckPlace;
        automobiles = new ArrayList<>(automobilePlace);
        trucks = new ArrayList<>(truckPlace);
    }

    public List<Car> getAutomobiles() {
        return automobiles;
    }

    public List<Car> getTrucks() {
        return trucks;
    }

    @Override
    public boolean accept(Car car) {
        if (car.size() == 1) {
            return automobilePlace > 0;
        }
        if (truckPlace > 0) {
            return true;
        }
        return automobilePlace >= car.size();
    }

    @Override
    public boolean park(Car car) {
        if (accept(car)) {
            if (car.size() == 1) {
                automobiles.add(car);
                automobilePlace--;
                return true;
            }
            if (truckPlace > 0) {
                trucks.add(car);
                truckPlace--;
                return true;
            }
            automobiles.add(car);
            automobilePlace -= car.size();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Car car) {
        if (automobiles.remove(car)) {
            if (car.size() == 1) {
                automobilePlace++;
            } else {
                automobilePlace += car.size();
            }
            return true;
        }
        if (trucks.remove(car)) {
            truckPlace++;
            return true;
        }
        return false;
    }
}
