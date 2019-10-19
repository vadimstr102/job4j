package ru.job4j.oop;

public class Engineer extends Profession {
    private int pricePerHour;

    public Engineer(String name, String surname, String education, String birthday, int pricePerHour) {
        super(name, surname, education, birthday);
        this.pricePerHour = pricePerHour;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }
}
