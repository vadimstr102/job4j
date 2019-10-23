package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateID());
        this.items[position++] = item;
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
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    this.items[i] = item;
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
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    this.items[i] = null;
                    System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                    this.items[this.items.length - 1] = null;
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
    public Item[] findAll() {
        int resultLength = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                resultLength++;
            }
        }
        Item[] result = new Item[resultLength];
        int resultIndex = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                result[resultIndex++] = this.items[i];
            }
        }
        return result;
    }

    /**
     * Метод возвращает массив с элементами, у которых имя совпадает с аргументом метода.
     * @param key искомое имя.
     * @return новый массив.
     */
    public Item[] findByName(String key) {
        int resultLength = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getName().equals(key)) {
                    resultLength++;
                }
            }
        }
        Item[] result = new Item[resultLength];
        int resultIndex = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getName().equals(key)) {
                    result[resultIndex++] = this.items[i];
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
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    result = this.items[i];
                    break;
                }
            }
        }
        return result;
    }
}
