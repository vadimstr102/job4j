package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextFromFileCache extends AbstractCache<String> {
    private final Map<String, SoftReference<String>> cache = new HashMap<>();

    @Override
    public String get(String fileName) {
        if (cache.containsKey(fileName)) {
            String result = cache.get(fileName).get();
            if (result != null) {
                return result;
            }
        }
        load(fileName);
        return cache.get(fileName).get();
    }

    private void load(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.lines().forEach(line -> {
                sb.append(line);
                sb.append("\r\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        cache.put(fileName, new SoftReference<>(sb.toString()));
    }

    public static void main(String[] args) {
        TextFromFileCache textCache = new TextFromFileCache();
        String fileName1 = Objects.requireNonNull(TextFromFileCache.class
                .getClassLoader()
                .getResource("profiling.txt"))
                .getPath();
        String fileName2 = Objects.requireNonNull(TextFromFileCache.class
                .getClassLoader()
                .getResource("names.txt"))
                .getPath();
        System.out.println(textCache.get(fileName1));
        System.out.println(textCache.get(fileName2));
        System.out.println(textCache.get(fileName1));
        System.out.println(textCache.get(fileName2));
    }
}
