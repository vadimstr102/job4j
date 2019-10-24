package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int spichki = 11;
        while (true) {
            System.out.print("Игрок №1, возьмите от 1 до 3 спичек:");
            int one = Integer.valueOf(scanner.nextLine());
            spichki -= one;
            if (spichki <= 0) {
                System.out.println("Игрок №1 победил!");
                break;
            }
            System.out.println("Осталось спичек: " + spichki);
            System.out.print("Игрок №2, возьмите от 1 до 3 спичек:");
            int two = Integer.valueOf(scanner.nextLine());
            spichki -= two;
            if (spichki <= 0) {
                System.out.println("Игрок №2 победил!");
                break;
            }
            System.out.println("Осталось спичек: " + spichki);
        }
    }
}
