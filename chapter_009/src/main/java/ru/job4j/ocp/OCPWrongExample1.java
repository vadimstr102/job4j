package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.List;

public class OCPWrongExample1 {
    class WrongClass {
        private ArrayList<String> list = new ArrayList<>();

        public List<String> load() {
            //do something
            return list;
        }
    }

    //Поля класса должны быть абстрактного типа. Правильный вариант:

    class GoodClass {
        private List<String> list;

        public GoodClass(List<String> list) {
            this.list = list;
        }

        public List<String> load() {
            //do something
            return list;
        }
    }
}
