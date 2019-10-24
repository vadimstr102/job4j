package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("The bus is going.");
    }

    @Override
    public void passengers(int passCount) {
        System.out.println(passCount + " passengers in the bus.");
    }

    @Override
    public double fillUp(double fuel) {
        return fuel * 50;
    }
}
