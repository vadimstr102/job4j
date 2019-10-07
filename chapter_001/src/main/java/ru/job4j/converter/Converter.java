package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }
    public static int rubleToDollar(int value) {
        return value / 60;
    }
    public static int euroToRubles(int value) {
        return value * 70;
    }
    public static int dollarToRubles(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");

        int dollar = rubleToDollar(180);
        System.out.println("180 rubles are " + dollar + " dollars.");

        int rubleOfEuro = euroToRubles(200);
        System.out.println("200 euro are " + rubleOfEuro + " rubles.");

        int rubleOfDollar = dollarToRubles(250);
        System.out.println("250 dollars are " + rubleOfDollar + " rubles.");

        //Tests:
        //1. rubleToEuro
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2 euro. Test result: " + passed);
        //2. rubleToDollar
        int in2 = 120;
        int expected2 = 2;
        int out2 = rubleToDollar(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("120 rubles are 2 dollars. Test result: " + passed2);
        //3. euroToRubles
        int in3 = 5;
        int expected3 = 350;
        int out3 = euroToRubles(in3);
        boolean passed3 = expected3 == out3;
        System.out.println("5 euro are 350 rubles. Test result: " + passed3);
        //4. dollarToRubles
        int in4 = 10;
        int expected4 = 600;
        int out4 = dollarToRubles(in4);
        boolean passed4 = expected4 == out4;
        System.out.println("10 dollars are 600 rubles. Test result: " + passed4);

    }
}
