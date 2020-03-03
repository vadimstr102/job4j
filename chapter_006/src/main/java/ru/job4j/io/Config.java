package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String pair;
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while ((pair = read.readLine()) != null) {
                if (pair.contains("#") || pair.equals("")) {
                    continue;
                }
                String key = pair.split("=")[0];
                String value = pair.split("=")[1];
                this.values.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (this.values.containsKey(key)) {
            return this.values.get(key);
        }
        throw new UnsupportedOperationException("This key is not valid!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
