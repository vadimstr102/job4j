package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray simpleArray = new SimpleArray(3);

    @Before
    public void start() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }


    @Test
    public void whenGetElement() {
        int result = (int) simpleArray.get(0);
        assertThat(result, is(1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddWithError() {
        simpleArray.add(4);
    }

    @Test
    public void whenSetElement() {
        simpleArray.set(2, 4);
        assertThat(simpleArray.get(2), is(4));
    }

    @Test
    public void whenRemoveElement() {
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(3));
        assertNull(simpleArray.get(2));
    }

    @Test
    public void whenUseIterator() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}
