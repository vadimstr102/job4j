package ru.job4j.lsp.storage;

import java.util.Calendar;

public class Bread extends Food {

    public Bread(String name, Calendar expiryDate, Calendar createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
