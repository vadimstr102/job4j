package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void ifArrayTrue() {
        Check check = new Check();
        boolean[] in = new boolean[] {true, true, true};
        boolean result = check.mono(in);
        assertThat(result, is(true));
    }

    @Test
    public void ifArrayFalse() {
        Check check = new Check();
        boolean[] in = new boolean[] {true, false, true};
        boolean result = check.mono(in);
        assertThat(result, is(false));
    }
}
