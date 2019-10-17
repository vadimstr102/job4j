package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(12);
        Battery second = new Battery(24);
        System.out.println("Battery first is: " + first.load + " Voltage. Battery second is: " + second.load + " Voltage.");
        first.exchange(second);
        System.out.println("Battery first is: " + first.load + " Voltage. Battery second is: " + second.load + " Voltage.");
    }
}
