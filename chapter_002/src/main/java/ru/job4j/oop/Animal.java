package ru.job4j.oop;

public class Animal {
    private String name;

    public Animal(String name) {
        super();
        this.name = name;
        System.out.println(getClass().getName());
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Barsik");
        Predator predator = new Predator("Barsik");
        Tiger tiger = new Tiger("Barsik");
    }
}
