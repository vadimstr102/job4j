package ru.job4j.lsp.storage;

import java.util.Calendar;

public class Meat extends Food {

    public Meat(String name, Calendar expiryDate, Calendar createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
