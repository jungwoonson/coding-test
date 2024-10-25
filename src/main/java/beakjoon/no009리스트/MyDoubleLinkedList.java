package beakjoon.no009리스트;

public class MyDoubleLinkedList<E> {

    private int size = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public void add(E element) {
        Node<E> newNode = new Node<>(lastNode, element, null);
        if (size == 0) {
            firstNode = newNode;
        }
        lastNode = newNode;
        size++;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(null, element, firstNode);
        if (size == 0) {
            lastNode = newNode;
        } else {
            firstNode.prev = newNode;
        }
        firstNode = newNode;
        size++;
    }

    public void insert(Node<E> prevNode, E element) {
        Node<E> newNode = new Node<>(prevNode, element, prevNode.next);
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        if (newNode.next == null) {
            lastNode = newNode;
        }
        size++;
    }

    public void insert(int idx, E element) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
        if (idx == 0) {
            addFirst(element);
        } else if (idx == size) {
            add(element);
        } else {
            insert(getNode(idx - 1), element);
        }
    }

    public Node<E> getNode(int idx) {
        validateOutOfBound(idx);
        Node<E> currentNode = firstNode;
        for (int i = 0; i < idx; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public E get(int idx) {
        return getNode(idx).item;
    }

    public void remove(Node<E> targetNode) {
        if (targetNode.prev != null) {
            targetNode.prev.next = targetNode.next;
        } else {
            firstNode = targetNode.next;
        }

        if (targetNode.next != null) {
            targetNode.next.prev = targetNode.prev;
        } else {
            lastNode = targetNode.prev;
        }

        targetNode.prev = null;
        targetNode.next = null;
        targetNode.item = null;

        size--;
    }

    public void remove(int idx) {
        validateOutOfBound(idx);
        remove(getNode(idx));
    }

    private void validateOutOfBound(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
    }

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }
}
