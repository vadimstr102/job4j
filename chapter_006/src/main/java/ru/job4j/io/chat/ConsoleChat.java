package ru.job4j.io.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    Bot bot;
    String pathToLog;

    public ConsoleChat(Bot bot, String pathToLog) {
        this.bot = bot;
        this.pathToLog = pathToLog;
    }

    public void start() {
        String question;
        String answer;
        List<String> logList = new ArrayList<>();

        try (BufferedReader readQuestion = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Chat started");
            question = readQuestion.readLine();
            while (!"закончить".equalsIgnoreCase(question)) {
                logList.add(question);
                if ("стоп".equalsIgnoreCase(question)) {
                    question = readQuestion.readLine();
                    while (!"продолжить".equalsIgnoreCase(question)) {
                        logList.add(question);
                        question = readQuestion.readLine();
                    }
                    logList.add(question);
                }
                answer = bot.ask();
                logList.add(answer);
                System.out.println(answer);
                question = readQuestion.readLine();
            }
            logList.add(question);
            System.out.println("Chat is over");
        } catch (Exception e) {
            e.printStackTrace();
        }

        WriteFile.write(logList, pathToLog);
    }

    public static void main(String[] args) {
        Bot bot = new Bot("chapter_006/src/main/resources/answers.txt");
        ConsoleChat consoleChat = new ConsoleChat(bot, "chapter_006/src/main/resources/chat_log.txt");
        consoleChat.start();
    }
}
