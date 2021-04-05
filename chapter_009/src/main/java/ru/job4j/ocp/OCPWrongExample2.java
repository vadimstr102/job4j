package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.List;

public class OCPWrongExample2 {
    class WrongClass {
        public ArrayList<String> load() {
            ArrayList<String> list = new ArrayList<>();
            //do something
            return list;
        }
    }

    //Возвращаемое значение должно быть абстрактного типа. Правильный вариант:

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
