package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class CarParkingTest {

    @Test
    public void whenAutomobilePark() {
        CarParking carParking = new CarParking(3, 3, new ArrayList<>());
        Car car = new Automobile();
        Assert.assertTrue(carParking.park(car));
    }

    @Test
    @Ignore
    public void whenAutomobileNotPark() {
        CarParking carParking = new CarParking(1, 3, new ArrayList<>());
        Car carOne = new Automobile();
        Car carTwo = new Automobile();
        Assert.assertTrue(carParking.park(carOne));
        Assert.assertFalse(carParking.park(carTwo));
    }

    @Test
    public void whenTruckPark() {
        CarParking carParking = new CarParking(3, 3, new ArrayList<>());
        Car truck = new Truck(3);
        Assert.assertTrue(carParking.park(truck));
    }

    @Test
    @Ignore
    public void whenTruckParkToAutomobilePark() {
        CarParking carParking = new CarParking(3, 1, new ArrayList<>());
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertTrue(carParking.park(truckTwo));
    }

    @Test
    @Ignore
    public void whenTruckNotPark() {
        CarParking carParking = new CarParking(2, 1, new ArrayList<>());
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertFalse(carParking.park(truckTwo));
    }

    @Test
    @Ignore
    public void whenAutomobileAndTruckPark() {
        CarParking carParking = new CarParking(5, 1, new ArrayList<>());
        Car carOne = new Automobile();
        Car carTwo = new Automobile();
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(carOne));
        Assert.assertTrue(carParking.park(carTwo));
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertTrue(carParking.park(truckTwo));
    }

    @Test
    @Ignore
    public void whenAutomobileAndTruckNotPark() {
        CarParking carParking = new CarParking(1, 1, new ArrayList<>());
        Car carOne = new Automobile();
        Car carTwo = new Automobile();
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(carOne));
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertFalse(carParking.park(carTwo));
        Assert.assertFalse(carParking.park(truckTwo));
    }

    @Test
    public void whenDeleteTrue() {
        CarParking carParking = new CarParking(3, 3, new ArrayList<>());
        Car car = new Automobile();
        Car truck = new Truck(3);
        carParking.park(car);
        carParking.park(truck);
        Assert.assertTrue(carParking.delete(car));
        Assert.assertTrue(carParking.delete(truck));
    }

    @Test
    @Ignore
    public void whenDeleteFalse() {
        CarParking carParking = new CarParking(3, 3, new ArrayList<>());
        Car car = new Automobile();
        Car truck = new Truck(3);
        carParking.park(car);
        carParking.park(truck);
        Assert.assertFalse(carParking.delete(new Automobile()));
        Assert.assertFalse(carParking.delete(new Truck(3)));
    }
}
