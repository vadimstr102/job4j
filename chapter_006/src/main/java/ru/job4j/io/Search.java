package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

public class Search {
    /**
     * @param parent    - path to the folder where the search starts
     * @param predicate - predicate of searched files
     * @return - list of files with the desired extensions
     */
    public static List<File> files(String parent, Predicate<File> predicate) {
        List<File> result = new ArrayList<>();
        File file = new File(parent);
        Queue<File> data = new LinkedList<>();
        data.offer(file);
        while (!data.isEmpty()) {
            File element = data.poll();
            if (element.isDirectory()) {
                data.addAll(List.of(Objects.requireNonNull(element.listFiles())));
            } else if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
