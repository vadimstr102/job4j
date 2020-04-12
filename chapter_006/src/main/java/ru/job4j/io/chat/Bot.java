package ru.job4j.io.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Bot {
    private List<String> answers;

    public Bot(String path) {
        initialize(path);
    }

    private void initialize(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            answers = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String ask() {
        return answers.get((int) (Math.random() * answers.size()));
    }
}
