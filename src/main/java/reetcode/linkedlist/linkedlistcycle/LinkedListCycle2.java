package reetcode.linkedlist.linkedlistcycle;

public class LinkedListCycle2 {

    // Constraints:
    // The number of the nodes in the list is in the range [0, 10^4].
    // -10^5 <= Node.val <= 10^5
    // pos is -1 or a valid index in the linked-list.
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
