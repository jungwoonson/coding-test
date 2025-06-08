package reetcode.linkedlist;

public class ReverseLinkedList {

    // Constraints:
    // The number of nodes in the list is the range [0, 5000].
    //-5000 <= Node.val <= 5000
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
