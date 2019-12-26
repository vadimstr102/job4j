package ru.job4j.list;

public class Node<T> {
    private T value;
    public Node<T> next;

    Node(T value) {
        this.value = value;
    }

    public boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> node1 = first;
        Node<T> node2 = first;
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                result = true;
                break;
            }
        }
        return result;
    }
}
