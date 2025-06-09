package reetcode.linkedlist;

public class RemoveLinkedListElements {

    // Constraints:
    // The number of nodes in the list is in the range [0, 10^4].
    // 1 <= Node.val <= 50
    // 0 <= val <= 50
    public ListNode removeElements(ListNode head, int val) {
        ListNode tempHead = new ListNode(-1, head);

        ListNode prev = tempHead;
        ListNode current = prev.next;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                current = prev.next;
                continue;
            }
            prev = current;
            current = current.next;
        }

        return tempHead.next;
    }
}
