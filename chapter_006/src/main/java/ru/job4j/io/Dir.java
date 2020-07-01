package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Dir {
    public static long sizeFile(Path folder) throws IOException {
        return Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("c:/projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", sizeFile(file.toPath())));
        for (File subFile : Objects.requireNonNull(file.listFiles())) {
            System.out.println(subFile.getName() + " : " + sizeFile(subFile.toPath()));
        }
    }
}
