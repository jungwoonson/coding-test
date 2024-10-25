package beakjoon.no009리스트;

public class MySingleLinkedList<E> {

    public int size = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, firstNode);
        if (size == 0) {
            lastNode = newNode;
        }
        firstNode = newNode;
        size++;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
        size++;
    }

    public Node<E> getNode(int idx) {
        validateIndex(idx);
        Node<E> currentNode = firstNode;
        for (int i = 0; i < idx; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public E get(int idx) {
        return getNode(idx).item;
    }

    public void set(int idx, E element) {
        Node<E> targetNode = getNode(idx);
        targetNode.item = element;
    }

    public void insert(Node<E> prevNode, E element) {
        Node<E> newNode = new Node<>(element, prevNode.next);
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
            Node<E> prevNode = getNode(idx - 1);
            insert(prevNode, element);
        }
    }

    public void remove(int idx) {
        validateIndex(idx);
        if (idx == 0) {
            removeFirst();
        } else {
            removeNext(getNode(idx - 1));
        }
    }

    public void removeFirst() {
        if (firstNode == null) {
            return;
        }
        firstNode = firstNode.next;
        if (firstNode == null) {
            lastNode = null;
        }
        size--;
    }

    public void removeNext(Node<E> prevNode) {
        if (prevNode.next == null) {
            return;
        }
        prevNode.next = prevNode.next.next;
        if (prevNode.next == null) {
            lastNode = prevNode;
        }
        size--;
    }

    public int size() {
        return size;
    }

    private void validateIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> currentNode = firstNode;
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(currentNode.item.toString());
            if (i < size - 1) {
                sb.append(", ");
            }
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
