package reetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    // Constraints:
    // 0 <= n <= 1000
    // -10^4 <= Node.val <= 10^4
    // Node.random is null or is pointing to some node in the linked list.
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
