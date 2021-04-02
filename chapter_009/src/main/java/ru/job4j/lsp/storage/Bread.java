package ru.job4j.lsp.storage;

import java.util.Calendar;

public class Bread extends Food {

    public Bread(String name, Calendar createDate, Calendar expiryDate, double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
