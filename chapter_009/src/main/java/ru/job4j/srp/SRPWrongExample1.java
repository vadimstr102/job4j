package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;

public class SRPWrongExample1 {
    //Создание объекта типа List внутри класса. Вместо этого нужно передать его в конструктор.

    private List<String> list = new ArrayList<>();

    public List<String> getFilledList() {
        //do something
        return list;
    }
}
