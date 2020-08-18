package ru.job4j.exam;

import java.util.Stack;

/**
 * @author Vadim Timofeev
 */
public class Shell {
    private Stack<String> st = new Stack<>();

    public void cd(String path) {
        if (path.contains("/") && !path.equals("/")) {
            String[] arr = path.split("/");
            for (String s : arr) {
                st.push("/" + s);
            }
        } else {
            path = "/" + path;
            st.push(path);
        }
        if (st.peek().endsWith("..")) {
            st.pop();
            if (!st.empty()) {
                st.pop();
            }
        }
        if (!st.empty() && st.peek().endsWith("/")) {
            st.clear();
        }
    }

    public String pwd() {
        if (st.size() == 0) {
            return "/";
        }
        return st.toString().replaceAll("[\\[\\], ]", "");
    }
}
