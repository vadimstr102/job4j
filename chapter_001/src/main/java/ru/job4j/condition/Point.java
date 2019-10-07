package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);

        double result2 = distance(1, 1, 25, 1);
        System.out.println("result (1, 1) to (25, 1) " + result2);

        double result3 = distance(2, 2, 2, 15);
        System.out.println("result (2, 2) to (2, 15) " + result3);
    }
}
