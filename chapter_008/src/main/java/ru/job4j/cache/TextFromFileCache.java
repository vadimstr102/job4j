package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Objects;

public class TextFromFileCache extends AbstractCache<StringBuilder> {
    private SoftReference<StringBuilder> softReference;
    private String fileName;

    @Override
    public StringBuilder get(String fileName) {
        if (fileName.equals(this.fileName)) {
            StringBuilder sb = this.softReference.get();
            if (sb != null) {
                return sb;
            }
        }
        this.fileName = fileName;
        this.softReference = new SoftReference<>(load(fileName));
        return this.softReference.get();
    }

    private StringBuilder load(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            bf.lines().forEach(line -> {
                sb.append(line);
                sb.append("\r\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void main(String[] args) {
        TextFromFileCache textCache = new TextFromFileCache();
        String fileName = Objects.requireNonNull(TextFromFileCache.class
                .getClassLoader()
                .getResource("names.txt"))
                .getPath();
        StringBuilder sb = textCache.get(fileName);
        System.out.println(sb);
    }
}
