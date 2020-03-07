package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {
    /**
     * @param parent     - path to the folder where the search starts
     * @param extensions - list of searched file extensions
     * @return - list of files with the desired extensions
     */
    public static List<File> files(String parent, List<String> extensions) {
        List<File> result = new ArrayList<>();
        Set<String> extensionsSet = new HashSet<>(extensions);
        String extension;
        File file = new File(parent);
        Queue<File> data = new LinkedList<>();
        data.offer(file);
        while (!data.isEmpty()) {
            File element = data.poll();
            if (element.isDirectory()) {
                data.addAll(List.of(Objects.requireNonNull(element.listFiles())));
            } else {
                extension = element.getName().split("\\.")[1];
                if (extensionsSet.contains(extension)) {
                    result.add(element);
                }
            }
        }
        return result;
    }
}
