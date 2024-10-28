package beakjoon.no010큐;

public class MyListQueue<E> {

    private int size = 0;
    private Node<E> frontNode;
    private Node<E> rearNode;

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) {
            frontNode = newNode;
        } else {
            rearNode.next = newNode;
            rearNode = newNode;
        }
    }

    public E dequeue() {
        if (size == 0) {
            throw new IllegalStateException("큐가 비어있습니다.");
        }
        E item = frontNode.item;
        frontNode = frontNode.next;
        if (frontNode == null) {
            rearNode = null;
        }
        size--;
        return item;
    }

}
