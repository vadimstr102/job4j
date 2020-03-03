package ru.job4j.io;

import java.io.*;

public class Analyze {
    public void unavailable(String source, String target) throws FileNotFoundException {
        String log;
        String number;
        String time1;
        String time2;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while (read.ready()) {
                log = read.readLine();
                number = log.split(" ")[0];
                if (number.equals("400") || number.equals("500")) {
                    time1 = log.split(" ")[1];
                    while (read.ready()) {
                        log = read.readLine();
                        number = log.split(" ")[0];
                        if (number.equals("200") || number.equals("300")) {
                            time2 = log.split(" ")[1];
                            stringBuilder.append(time1 + ";" + time2 + System.lineSeparator());
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeToFile(target, stringBuilder);
    }

    private void writeToFile(String target, StringBuilder stringBuilder) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(target));
        out.print(stringBuilder);
        out.close();
    }
}
