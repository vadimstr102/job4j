package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return searchInList(value, (t1, t2) -> comparator.compare(t1, t2) > 0 ? t1 : t2);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return searchInList(value, (t1, t2) -> comparator.compare(t1, t2) < 0 ? t1 : t2);
    }

    private <T> T searchInList(List<T> value, BinaryOperator<T> binaryOperator) {
        T result = value.get(0);
        for (T t : value) {
            result = binaryOperator.apply(result, t);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxMin maxMin = new MaxMin();

        List<Integer> listI = List.of(1, 2, 3, 4, 5);
        int minI = maxMin.min(listI, Integer::compareTo);
        int maxI = maxMin.max(listI, Integer::compareTo);

        System.out.println("minimum value: " + minI);
        System.out.println("maximum value: " + maxI);

        List<String> listS = List.of("A", "B", "C", "D", "E");
        String minS = maxMin.min(listS, String::compareTo);
        String maxS = maxMin.max(listS, String::compareTo);

        System.out.println("minimum value: " + minS);
        System.out.println("maximum value: " + maxS);
    }
}
