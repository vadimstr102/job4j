package ru.job4j.dip;

import java.util.ArrayList;

public class DIPWrongExample3 {
    class Store {
        //some code
    }

    class StoreService {
        public ArrayList<String> loadGoods(Store store) {
            ArrayList<String> arrayList = new ArrayList<>();
            //do something
            return arrayList;
        }
    }

    /*
     * Метод loadGoods() класса StoreService возвращает объект конкретного класса ArrayList, а также принимает
     * в качестве аргумента объект конкретного класса Store.
     * Это является нарушением принципа DIP.
     * */
}
