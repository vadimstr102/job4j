package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        if (second > result) {
            result = second > third ? second : third;
        } else if (third > result) {
            result = third > second ? third : second;
        }
        return result;
    }
}
