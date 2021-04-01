package ru.job4j.lsp.parking;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class CarParkingTest {
    @Test
    public void whenAutomobilePark() {
        CarParking carParking = new CarParking(3, 3);
        Car car = new Automobile();
        Assert.assertTrue(carParking.park(car));
        Assert.assertThat(carParking.getAutomobiles().size(), is(1));
        Assert.assertThat(carParking.getTrucks().size(), is(0));
    }

    @Test
    public void whenAutomobileNotPark() {
        CarParking carParking = new CarParking(1, 3);
        Car carOne = new Automobile();
        Car carTwo = new Automobile();
        Assert.assertTrue(carParking.park(carOne));
        Assert.assertFalse(carParking.park(carTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(1));
        Assert.assertThat(carParking.getTrucks().size(), is(0));
    }

    @Test
    public void whenTruckPark() {
        CarParking carParking = new CarParking(3, 3);
        Car truck = new Truck(3);
        Assert.assertTrue(carParking.park(truck));
        Assert.assertThat(carParking.getAutomobiles().size(), is(0));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }

    @Test
    public void whenTruckParkToAutomobilePark() {
        CarParking carParking = new CarParking(3, 1);
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertTrue(carParking.park(truckTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(1));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }

    @Test
    public void whenTruckNotPark() {
        CarParking carParking = new CarParking(2, 1);
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertFalse(carParking.park(truckTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(0));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }

    @Test
    public void whenAutomobileAndTruckPark() {
        CarParking carParking = new CarParking(5, 1);
        Car carOne = new Automobile();
        Car carTwo = new Automobile();
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(carOne));
        Assert.assertTrue(carParking.park(carTwo));
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertTrue(carParking.park(truckTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(3));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }

    @Test
    public void whenAutomobileAndTruckNotPark() {
        CarParking carParking = new CarParking(1, 1);
        Car carOne = new Automobile();
        Car carTwo = new Automobile();
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(carOne));
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertFalse(carParking.park(carTwo));
        Assert.assertFalse(carParking.park(truckTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(1));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }

    @Test
    public void whenDeleteTrue() {
        CarParking carParking = new CarParking(3, 3);
        Car car = new Automobile();
        Car truck = new Truck(3);
        carParking.park(car);
        carParking.park(truck);
        Assert.assertTrue(carParking.delete(car));
        Assert.assertTrue(carParking.delete(truck));
        Assert.assertThat(carParking.getAutomobiles().size(), is(0));
        Assert.assertThat(carParking.getTrucks().size(), is(0));
    }

    @Test
    public void whenDeleteFalse() {
        CarParking carParking = new CarParking(3, 3);
        Car car = new Automobile();
        Car truck = new Truck(3);
        carParking.park(car);
        carParking.park(truck);
        Assert.assertFalse(carParking.delete(new Automobile()));
        Assert.assertFalse(carParking.delete(new Truck(3)));
        Assert.assertThat(carParking.getAutomobiles().size(), is(1));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }

    @Test
    public void whenTruckParkToAutomobileParkAndDelete() {
        CarParking carParking = new CarParking(3, 1);
        Car truckOne = new Truck(3);
        Car truckTwo = new Truck(3);
        Assert.assertTrue(carParking.park(truckOne));
        Assert.assertTrue(carParking.park(truckTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(1));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
        Assert.assertTrue(carParking.delete(truckTwo));
        Assert.assertThat(carParking.getAutomobiles().size(), is(0));
        Assert.assertThat(carParking.getTrucks().size(), is(1));
    }
}
