package ru.job4j.oop;

public class Animal {
    public Animal() {
        super();
        System.out.println(getClass().getName());
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Predator predator = new Predator();
        Tiger tiger = new Tiger();
    }
}
