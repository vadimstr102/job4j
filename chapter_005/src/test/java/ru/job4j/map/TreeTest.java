package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(6).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddElements() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.add(1, 2), is(false));
        assertThat(tree.add(6, 7), is(true));
        assertThat(tree.add(8, 3), is(true));
    }

    @Test
    public void whenIsBinaryTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        tree.add(7, 8);
        tree.add(7, 9);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenIsBinaryFalseInRoot() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(7, 9);
        tree.add(7, 10);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenIsBinaryFalseInChildrenOfRoot() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(7, 9);
        tree.add(7, 10);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenIsBinaryFalseInChildrenOfChildren() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        tree.add(7, 8);
        tree.add(7, 9);
        tree.add(7, 10);
        assertThat(tree.isBinary(), is(false));
    }
}
