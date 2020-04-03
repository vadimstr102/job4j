package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {
    public void start() {
        String question;
        String answer;
        List<String> answersPool = new ArrayList<>();
        List<String> logList = new ArrayList<>();
        //считываем ответы из файла в список
        try (BufferedReader readAnswer = new BufferedReader(new FileReader("chapter_006/src/main/resources/answers.txt"))) {
            answersPool = readAnswer.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //считываем строки из консоли
        try (BufferedReader readQuestion = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Chat started");
            //читаем ввод из консоли в цикле
            question = readQuestion.readLine();
            while (!"закончить".equals(question)) {
                //запись question в лог-список
                logList.add(question);
                if ("стоп".equals(question)) {
                    question = readQuestion.readLine();
                    while (!"продолжить".equals(question)) {
                        //запись question в лог-список
                        logList.add(question);
                        question = readQuestion.readLine();
                    }
                    //запись question "продолжить" в лог-список
                    logList.add(question);
                }
                //присваиваем переменной answer случайный ответ из List, записываем её в лог-список и выводим на консоль
                answer = answersPool.get((int) (Math.random() * answersPool.size()));
                logList.add(answer);
                System.out.println(answer);
                question = readQuestion.readLine();
            }
            //запись question "закончить" в лог-список
            logList.add(question);
            System.out.println("Chat is over");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //записываем лог-список в файл
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter("chapter_006/src/main/resources/chat_log.txt"))) {
            for (String s : logList) {
                logWriter.write(s + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start();
    }
}
