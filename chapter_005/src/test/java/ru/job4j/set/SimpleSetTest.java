package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    SimpleSet<Integer> set = new SimpleSet<>();

    @Before
    public void start() {
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void whenAddElements() {
        assertThat(set.add(4), is(true));
        assertThat(set.add(5), is(true));
        assertThat(set.add(2), is(false));
        assertThat(set.add(3), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUseIterator() {
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
