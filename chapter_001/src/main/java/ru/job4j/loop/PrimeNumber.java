package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        boolean prime;
        for (int i = 2; i <= finish; i++) {
            prime = checkPrimeNumber.check(i);
            if (prime) {
                count++;
            }
        }
        return count;
    }
}
