package ru.job4j.map;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl;
        Optional<Node<E>> pNode = findBy(parent);
        Optional<Node<E>> cNode = findBy(child);
        if (pNode.isPresent() && cNode.isPresent()) {
            rsl = false;
        } else if (pNode.isPresent()) {
            pNode.get().children.add(new Node<>(child));
            rsl = true;
        } else if (cNode.isPresent()) {
            this.root.children.add(new Node<>(parent));
            rsl = true;
        } else {
            this.root.children.add(new Node<>(parent));
            findBy(parent).get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
