package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        double weight = (height - 100) * 1.15;
        return weight;
    }
    public static double womanWeight(double height) {
        double weight = (height - 110) * 1.15;
        return weight;
    }

    public static void main(String[] args) {
        double man = manWeight(175);
        System.out.println("Man 175 is " + man);
        double woman = womanWeight(167);
        System.out.println("Woman 167 is " + woman);
    }
}
