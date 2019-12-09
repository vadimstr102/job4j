package ru.job4j.lambda;

public class Pair {
    private String name;
    private String unit;

    public Pair(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
