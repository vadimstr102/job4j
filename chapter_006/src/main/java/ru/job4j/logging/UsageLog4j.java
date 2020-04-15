package ru.job4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 516546465465L;
        float f = 545465.4546565f;
        double d = 98976967876.5635635;
        boolean bool = true;
        char c = 'j';
        String ls = System.lineSeparator();
        LOG.debug("Java has eight primitive types:{}byte - {}{}short - {}{}int - {}{}long - {}{}float - {}{}double - {}{}boolean - {}{}char - {}",
                ls, b, ls, s, ls, i, ls, l, ls, f, ls, d, ls, bool, ls, c);
    }
}
