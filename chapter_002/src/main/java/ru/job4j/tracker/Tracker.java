package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateID());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateID() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод заменяет ячейку в массиве.
     * @param id заменяемой ячейки.
     * @param item новая заявка.
     * @return удалось ли заменить.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item aItem: this.items) {
            if (aItem != null) {
                if (aItem.getId().equals(id)) {
                    aItem.setName(item.getName());
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод удаляет ячейку в массиве и сдвигает пустую ячейку в конец массива.
     * @param id удаляемая ячейка.
     * @return удалось ли удалить.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item aItem: this.items) {
            if (aItem != null) {
                if (aItem.getId().equals(id)) {
                    this.items.remove(aItem);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод возвращает копию массива без null элементов.
     * @return копия массива.
     */
    public List<Item> findAll() {
        int resultLength = 0;
        for (Item aItem: this.items) {
            if (aItem != null) {
                resultLength++;
            }
        }
        List<Item> result = new ArrayList<>(resultLength);
        for (Item aItem: this.items) {
            if (aItem != null) {
                result.add(aItem);
            }
        }
        return result;
    }

    /**
     * Метод возвращает массив с элементами, у которых имя совпадает с аргументом метода.
     * @param key искомое имя.
     * @return новый массив.
     */
    public List<Item> findByName(String key) {
        int resultLength = 0;
        for (Item aItem: this.items) {
            if (aItem != null) {
                if (aItem.getName().equals(key)) {
                    resultLength++;
                }
            }
        }
        List<Item> result = new ArrayList<>(resultLength);
        for (Item aItem: this.items) {
            if (aItem != null) {
                if (aItem.getName().equals(key)) {
                    result.add(aItem);
                }
            }
        }
        return result;
    }

    /**
     * Метод возвращает элемент по id, либо null.
     * @param id искомого элемента.
     * @return элемент Item, либо null.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item aItem: this.items) {
            if (aItem != null) {
                if (aItem.getId().equals(id)) {
                    result = aItem;
                    break;
                }
            }
        }
        return result;
    }
}
