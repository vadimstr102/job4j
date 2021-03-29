package ru.job4j.lsp.storage;

import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar expiryDate, Calendar createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
