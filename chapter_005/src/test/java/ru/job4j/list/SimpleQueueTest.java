package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();

    @Before
    public void start() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }

    @Test
    public void whenPollElements() {
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }

    @Test
    public void whenPushAndPollElements() {
        simpleQueue.push(4);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        simpleQueue.push(5);
        simpleQueue.push(6);
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.poll(), is(4));
        assertThat(simpleQueue.poll(), is(5));
        assertThat(simpleQueue.poll(), is(6));
    }
}
