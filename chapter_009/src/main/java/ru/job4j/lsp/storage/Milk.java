package ru.job4j.lsp.storage;

import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar createDate, Calendar expiryDate, double price, double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
