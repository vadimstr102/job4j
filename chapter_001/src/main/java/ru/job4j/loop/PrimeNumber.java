package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for(int i = 2; i <= finish; i++) {
            boolean prime = true;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime == true) {
                count++;
            }
        }
        return count;
    }
}
