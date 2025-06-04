package reetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {

    // Constraints:
    // The number of nodes in the list is sz.
    // 1 <= sz <= 30
    // 0 <= Node.val <= 100
    // 1 <= n <= sz

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
