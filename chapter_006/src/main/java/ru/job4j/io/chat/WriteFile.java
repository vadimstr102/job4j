package ru.job4j.io.chat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {
    public static void write(List<String> list, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String s : list) {
                writer.write(s + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
