package ru.job4j.exam;

import java.util.HashMap;

/**
 * @author Vadim Timofeev
 */
public class Article {
    public static boolean generateBy(String origin, String line) {
        //удаляем знаки пунктуации из обеих строк и приводим все буквы к нижнему регистру
        origin = origin.replaceAll("[.,:;!?'\"]", "").toLowerCase();
        line = line.replaceAll("[.,:;!?'\"]", "").toLowerCase();

        //добавляем слова из оригинального текста в карту в качестве ключей,
        //в качестве значений используем количество данных слов в тексте
        HashMap<String, Integer> originMap = new HashMap<>();
        for (String s : origin.split(" ")) {
            if (originMap.containsKey(s)) {
                int count = originMap.get(s);
                originMap.put(s, ++count);
            } else {
                originMap.put(s, 1);
            }
        }

        //ищем слова из новой строки в карте,
        //если находим - убавляем значение на единицу
        //если не находим, или количество данных слов в новой строке больше, чем в оригинальной -
        //возвращаем false
        for (String s : line.split(" ")) {
            if (originMap.containsKey(s)) {
                int count = originMap.get(s);
                if (count == 0) {
                    return false;
                }
                originMap.put(s, --count);
            } else {
                return false;
            }
        }
        return true;
    }
}
