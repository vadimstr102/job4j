package ru.job4j.exam;

import java.util.LinkedList;

/**
 * @author Vadim Timofeev
 */
public class Shell {
    private LinkedList<String> list = new LinkedList<>();

    public void cd(String path) {
        if (path.contains("/") && !path.equals("/")) {
            String[] arr = path.split("/");
            for (String s : arr) {
                list.add("/" + s);
            }
        } else {
            path = "/" + path;
            list.add(path);
        }
        if (list.getLast().endsWith("..")) {
            list.removeLast();
            if (!list.isEmpty()) {
                list.removeLast();
            }
        }
        if (!list.isEmpty() && list.getLast().endsWith("/")) {
            list.clear();
        }
    }

    public String pwd() {
        if (list.isEmpty()) {
            return "/";
        }
        return String.join("", list);
    }
}
