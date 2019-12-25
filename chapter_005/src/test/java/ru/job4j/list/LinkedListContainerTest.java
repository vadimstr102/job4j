package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LinkedListContainerTest {
    LinkedListContainer<Integer> linkedListContainer = new LinkedListContainer<>();

    @Before
    public void start() {
        linkedListContainer.add(0);
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        linkedListContainer.add(3);
        linkedListContainer.add(4);
    }

    @Test
    public void whenAddAndGetElements() {
        assertThat(linkedListContainer.getSize(), is(5));
        linkedListContainer.add(5);
        linkedListContainer.add(6);
        assertThat(linkedListContainer.getSize(), is(7));
        assertThat(linkedListContainer.get(1), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUseIterator() {
        Iterator<Integer> it = linkedListContainer.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorAndModList() {
        Iterator<Integer> it = linkedListContainer.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        linkedListContainer.add(5);
        it.hasNext();
    }
}
