package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> simpleStack = new SimpleStack<>();

    @Before
    public void start() {
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    @Test
    public void whenPollElements() {
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

    @Test
    public void whenPushAndPollElements() {
        simpleStack.push(4);
        simpleStack.push(5);
        assertThat(simpleStack.poll(), is(5));
        assertThat(simpleStack.poll(), is(4));
    }
}
