package ru.job4j.searchfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class LogWriter {
    public static void write(List<Path> list, String logFilePath) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath))) {
            for (Path filePath : list) {
                out.write(filePath.toString());
                out.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
