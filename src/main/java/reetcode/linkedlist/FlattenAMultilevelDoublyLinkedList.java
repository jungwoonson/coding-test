package reetcode.linkedlist;

public class FlattenAMultilevelDoublyLinkedList {

    // Constraints:
    // The number of nodes in each linked list is in the range [1, 100].
    // 0 <= Node.val <= 9
    // It is guaranteed that the list represents a number that does not have leading zeros.
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node child = current.child;
                current.child = null;

                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = current.next;
                if (tail.next != null) {
                    tail.next.prev = tail;
                }

                current.next = child;
                child.prev = current;
            }
            current = current.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
