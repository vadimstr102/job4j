package ru.job4j.lsp.storage;

import java.util.Map;

public class ControlQuality {
    private Map<String, Storage> map;

    public ControlQuality(Map<String, Storage> map) {
        this.map = map;
    }

    public void loadFood(Food food) {
        int quality = getQuality(food);
        if (quality < 25) {
            map.get("Warehouse").add(food);
        } else if (quality < 75) {
            map.get("Shop").add(food);
        } else if (quality < 100) {
            food.setDiscount(20);
            map.get("Shop").add(food);
        } else {
            map.get("Trash").add(food);
        }
    }

    private int getQuality(Food food) {
        long lifeTime = System.currentTimeMillis() - food.getCreateDate().getTimeInMillis();
        long totalLifeTime = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        return (int) (lifeTime * 100 / totalLifeTime);
    }
}
