package ru.job4j;

public class User {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected void finalize() {
        System.out.printf("Remove %d %s%n", age, name);
    }
}
