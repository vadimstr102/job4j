package ru.job4j.lsp.storage;

import java.util.List;

public class Shop implements Store {
    private final List<Food> list;

    public Shop(List<Food> list) {
        this.list = list;
    }

    @Override
    public boolean accept(Food food) {
        int quality = food.getQuality();
        if (quality >= 25) {
            if (quality < 75) {
                return true;
            } else if (quality < 100) {
                makeDiscount(food);
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            list.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return list;
    }

    private void makeDiscount(Food food) {
        double newPrice = food.getPrice() - food.getPrice() * food.getDiscount() / 100;
        food.setPrice(newPrice);
    }
}
