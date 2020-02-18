package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Iterable {
    private Node<K, V>[] table;
    private int size;
    private int modCount;

    public SimpleMap() {
        this.table = new Node[16];
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private List<Node<K, V>> nodes;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.nodes = new LinkedList<>();
        }
    }

    public int size() {
        return this.size;
    }

    private int hash(K key) {
        int h = key.hashCode();
        h = h ^ (h >>> 16);
        return h & (this.table.length - 1);
    }

    public boolean insert(K key, V value) {
        if (this.size + 1 >= this.table.length * 0.75) {
            arrayDoubling();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = this.hash(key);
        if (this.table[index] == null) {
            return this.simpleAdd(newNode, index);
        }
        List<Node<K, V>> nodeList = this.table[index].nodes;
        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode)) {
                return true;
            }
        }
        return collisionProcessing(newNode, nodeList);
    }

    private boolean simpleAdd(Node<K, V> node, int index) {
        this.table[index] = new Node<>(null, null);
        this.table[index].nodes.add(node);
        this.size++;
        this.modCount++;
        return true;
    }

    private boolean keyExistButValueNew(final Node<K, V> nodeFromList, final Node<K, V> newNode) {
        if (nodeFromList.key.hashCode() == newNode.key.hashCode()
                && Objects.equals(nodeFromList.key, newNode.key)) {
            nodeFromList.value = newNode.value;
            return true;
        }
        return false;
    }

    private boolean collisionProcessing(final Node<K, V> newNode, final List<Node<K, V>> nodeList) {
        nodeList.add(newNode);
        this.size++;
        this.modCount++;
        return true;
    }

    private void arrayDoubling() {
        Node<K, V>[] oldTable = this.table;
        this.table = new Node[oldTable.length * 2];
        this.size = 0;
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                for (Node<K, V> n : node.nodes) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    public boolean delete(final K key) {
        int index = this.hash(key);
        if (this.table[index] != null) {
            for (Node<K, V> node : this.table[index].nodes) {
                if (key.hashCode() == node.key.hashCode()
                        && Objects.equals(key, node.key)) {
                    this.table[index].nodes.remove(node);
                    this.size--;
                    this.modCount++;
                    break;
                } else {
                    return false;
                }
            }
            if (this.table[index].nodes.size() == 0) {
                this.table[index] = null;
            }
            return true;
        }
        return false;
    }

    public V get(final K key) {
        V result = null;
        int index = this.hash(key);
        if (this.table[index] != null) {
            for (Node<K, V> node : this.table[index].nodes) {
                if (key.hashCode() == node.key.hashCode()
                        && Objects.equals(key, node.key)) {
                    result = node.value;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            int arrayCounter = 0;
            int valuesCounter = 0;
            int itModCount = modCount;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (this.itModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (this.valuesCounter == size) {
                    return false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = table[arrayCounter].nodes.iterator();
                    } else {
                        return false;
                    }
                }
                return subIterator.hasNext();
            }

            private boolean moveToNextCell() {
                if (arrayCounter != 0) {
                    arrayCounter++;
                }
                while (arrayCounter < table.length && table[arrayCounter] == null) {
                    arrayCounter++;
                }
                return arrayCounter < table.length && table[arrayCounter] != null;
            }

            @Override
            public V next() {
                if (this.itModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                valuesCounter++;
                return subIterator.next().value;
            }
        };
    }
}
