package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {
    public void start() {
        String question;
        String answer;
        //открываем потоки ввода из консоли, чтения ответов из файла, записи в лог-файл
        try (
                BufferedReader readQuestion = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader readAnswer = new BufferedReader(new FileReader("chapter_006/src/main/resources/answers.txt"));
                BufferedWriter logWriter = new BufferedWriter(new FileWriter("chapter_006/src/main/resources/chat_log.txt"))
        ) {
            //заносим ответы из файла в List
            List<String> answersPool = readAnswer.lines().collect(Collectors.toList());
            System.out.println("Chat started");
            //читаем ввод из консоли в цикле
            question = readQuestion.readLine();
            while (!"закончить".equals(question)) {
                //запись question в лог
                logWriter.write(question + System.lineSeparator());
                if ("стоп".equals(question)) {
                    question = readQuestion.readLine();
                    while (!"продолжить".equals(question)) {
                        //запись question в лог
                        logWriter.write(question + System.lineSeparator());
                        question = readQuestion.readLine();
                    }
                    //запись question "продолжить" в лог
                    logWriter.write(question + System.lineSeparator());
                }
                //присваиваем переменной answer случайный ответ из List
                answer = answersPool.get((int) (Math.random() * answersPool.size()));
                //запись answer в лог и вывод на консоль
                logWriter.write(answer + System.lineSeparator());
                System.out.println(answer);
                question = readQuestion.readLine();
            }
            //запись question "закончить" в лог
            logWriter.write(question + System.lineSeparator());
            System.out.println("Chat is over");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start();
    }
}
