package ru.job4j.isp.menu;

import java.util.List;

public interface Menu<T extends Node<T>> {
    void startMenu(List<T> list);
}
