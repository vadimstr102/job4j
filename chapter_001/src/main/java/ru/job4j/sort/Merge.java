package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int iL = 0;
        int iR = 0;
        int i = 0;
        while (i < rsl.length) {
            if (iL < left.length) {
                if (iR < right.length) {
                    if (left[iL] < right[iR]) {
                        rsl[i] = left[iL];
                        iL++;
                    } else {
                        rsl[i] = right[iR];
                        iR++;
                    }
                } else {
                    rsl[i] = left[iL];
                    iL++;
                }
            } else if (iR < right.length) {
                rsl[i] = right[iR];
                iR++;
            }
            i++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
