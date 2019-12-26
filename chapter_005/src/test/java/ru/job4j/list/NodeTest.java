package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NodeTest {
    Node<Integer> first = new Node<>(1);
    Node<Integer> two = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> four = new Node<>(4);

    @Before
    public void start() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }

    @Test
    public void whenCircuitInTheEnd() {
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenCircuitInTheMiddle() {
        third.next = two;
        four.next = null;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenNoCircuit() {
        four.next = null;
        assertThat(first.hasCycle(first), is(false));
    }
}
