package ru.job4j.isp.menu;

import java.util.List;

public interface Node<T> {
    List<T> getChildNodes();
}
