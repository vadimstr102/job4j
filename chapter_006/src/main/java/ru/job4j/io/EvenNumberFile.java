package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            StringBuilder text = new StringBuilder();
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] integers = text.toString().split(System.lineSeparator());
            String result;
            int i;
            for (String s : integers) {
                i = Integer.parseInt(s);
                if (i % 2 == 0) {
                    result = " is even.";
                } else {
                    result = " is not even";
                }
                System.out.println(s + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
