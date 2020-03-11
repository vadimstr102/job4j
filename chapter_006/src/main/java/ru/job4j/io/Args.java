package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private String[] args;
    private Map<String, String> argsMap = new HashMap<>();

    public Args(String[] args) {
        this.args = args;
        this.mapInitial();
    }

    private void mapInitial() {
        for (int i = 0; i < this.args.length - 1; i += 2) {
            this.argsMap.put(this.args[i], this.args[i + 1]);
        }
    }

    public String directory() {
        return this.argsMap.get("-d");
    }

    public String exclude() {
        String s = this.argsMap.get("-e");
        return s.substring(s.lastIndexOf("."));
    }

    public String output() {
        return this.argsMap.get("-o");
    }
}
