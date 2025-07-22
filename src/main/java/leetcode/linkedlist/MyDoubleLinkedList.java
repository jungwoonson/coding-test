package leetcode.linkedlist;

class MyDoubleLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        size = 0;
    }
    
    public int get(int index) {
        return getNode(index).val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            tail = newNode;
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            tail = newNode;
            head = newNode;
            size++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node next = getNode(index);
        Node prev = next.prev;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            size--;
            if (size == 0) {
                head = null;
                tail = null;
                size--;
                return;
            }
            head = head.next;
            head.prev = null;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        Node target = getNode(index);
        Node next = target.next;
        Node prev = target.prev;

        prev.next = next;
        next.prev = prev;
        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size / 2 <= index) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        Node current = tail;
        int tailIndex = size - index - 1;
        for (int i = 0; i < tailIndex; i++) {
            current = current.prev;
        }
        return current;
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }
}