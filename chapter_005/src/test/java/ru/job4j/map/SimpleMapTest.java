package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {
    SimpleMap<Integer, String> simpleMap = new SimpleMap<>();

    @Before
    public void start() {
        simpleMap.insert(1, "one");
        simpleMap.insert(2, "two");
        simpleMap.insert(3, "three");
        simpleMap.insert(4, "four");
        simpleMap.insert(5, "five");
    }

    @Test
    public void whenInsertKey() {
        assertThat(simpleMap.size(), is(5));
        simpleMap.insert(6, "six");
        assertThat(simpleMap.size(), is(6));
        assertThat(simpleMap.get(6), is("six"));
    }

    @Test
    public void whenInsertExistsKey() {
        assertThat(simpleMap.get(5), is("five"));
        simpleMap.insert(5, "six");
        assertThat(simpleMap.size(), is(5));
        assertThat(simpleMap.get(5), is("six"));
        simpleMap.insert(5, "six");
        assertThat(simpleMap.size(), is(5));
    }

    @Test
    public void whenDeleteExistsPair() {
        assertThat(simpleMap.size(), is(5));
        assertThat(simpleMap.delete(3), is(true));
        assertThat(simpleMap.size(), is(4));
    }

    @Test
    public void whenDeleteNoExistsPair() {
        assertThat(simpleMap.size(), is(5));
        assertThat(simpleMap.delete(7), is(false));
        assertThat(simpleMap.size(), is(5));
    }

    @Test
    public void whenGetValue() {
        assertThat(simpleMap.get(1), is("one"));
        assertNull(simpleMap.get(6));
        assertThat(simpleMap.get(3), is("three"));
        assertNull(simpleMap.get(7));
        assertThat(simpleMap.get(5), is("five"));
        assertNull(simpleMap.get(8));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUseIterator() {
        Iterator<String> it = simpleMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.next(), is("two"));
        assertThat(it.next(), is("three"));
        assertThat(it.next(), is("four"));
        assertThat(it.next(), is("five"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAndModList() {
        Iterator<String> it = simpleMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.next(), is("two"));
        assertThat(it.hasNext(), is(true));
        simpleMap.insert(6, "six");
        it.next();
    }
}
