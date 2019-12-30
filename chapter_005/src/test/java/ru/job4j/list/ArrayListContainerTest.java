package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayListContainerTest {
    ArrayListContainer<Integer> arrayListContainer = new ArrayListContainer<>();

    @Before
    public void start() {
        arrayListContainer.add(0);
        arrayListContainer.add(1);
        arrayListContainer.add(2);
        arrayListContainer.add(3);
        arrayListContainer.add(4);
        arrayListContainer.add(5);
        arrayListContainer.add(6);
        arrayListContainer.add(7);
        arrayListContainer.add(8);
        arrayListContainer.add(9);
    }

    @Test
    public void whenAddAndGetElements() {
        assertThat(arrayListContainer.size(), is(10));
        arrayListContainer.add(10);
        arrayListContainer.add(11);
        assertThat(arrayListContainer.size(), is(12));
        assertThat(arrayListContainer.get(11), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIterator() {
        Iterator<Integer> it = arrayListContainer.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        arrayListContainer.add(10);
        it.next();
    }
}
