package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleListTest {
    SimpleList<Integer> simpleList = new SimpleList<>();

    @Before
    public void start() {
        simpleList.add(0);
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);
        simpleList.add(6);
        simpleList.add(7);
        simpleList.add(8);
        simpleList.add(9);
    }

    @Test
    public void whenAddAndGetElements() {
        assertThat(simpleList.size(), is(10));
        simpleList.add(10);
        simpleList.add(11);
        assertThat(simpleList.size(), is(20));
        assertThat(simpleList.get(11), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIterator() {
        Iterator<Integer> it = simpleList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        simpleList.add(10);
        it.next();
    }
}
