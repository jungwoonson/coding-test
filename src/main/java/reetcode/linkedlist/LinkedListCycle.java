package reetcode.linkedlist;

public class LinkedListCycle {

    // Constraints:
    // The number of the nodes in the list is in the range [0, 10^4].
    // -10^5 <= Node.val <= 10^5
    // pos is -1 or a valid index in the linked-list.
    public boolean hasCycle(ListNode head) {
        while (head != null && head.next != null) {
            if (head.val == Integer.MIN_VALUE) {
                return true;
            }
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }
        return false;
    }

    // One of the most well-known algorithms for detecting a cycle is the "Tortoise and Hare" algorithm,
    // also known as Floyd’s Cycle Detection Algorithm.
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;

            if(fast==slow)
                return true;
        }
        return false;
    }
}
