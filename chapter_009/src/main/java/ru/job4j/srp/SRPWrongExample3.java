package ru.job4j.srp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SRPWrongExample3 {
    //Создание одинаковых методов с разными условиями проверки. Вместо этого нужно использовать Predicate.

    public List<File> findByName(List<File> files, String name) {
        List<File> result = new ArrayList<>();
        //do something
        return result;
    }

    public List<File> findByExt(List<File> files, String ext) {
        List<File> result = new ArrayList<>();
        //do something
        return result;
    }
}
