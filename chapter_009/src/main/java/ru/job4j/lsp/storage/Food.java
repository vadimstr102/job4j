package ru.job4j.lsp.storage;

import java.util.Calendar;

public abstract class Food {

    private final String name;
    private final Calendar createDate;
    private final Calendar expiryDate;
    private double price;
    private double discount;

    public Food(String name, Calendar createDate, Calendar expiryDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    protected int getQuality() {
        long lifeTime = System.currentTimeMillis() - getCreateDate().getTimeInMillis();
        long totalLifeTime = getExpiryDate().getTimeInMillis() - getCreateDate().getTimeInMillis();
        return (int) (lifeTime * 100 / totalLifeTime);
    }
}
