package ru.job4j.cache;

public abstract class AbstractCache<T> {

    abstract T get(String filename);
}
