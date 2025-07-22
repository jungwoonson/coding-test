package leetcode.linkedlist;

public class RotateList {

    // Constraints:
    // The number of nodes in the list is in the range [0, 500].
    // -100 <= Node.val <= 100
    //  0 <= k <= 2 * 10^9
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        current.next = head;

        k = k % count;
        for (int i = 0; i < count - k; i++) {
            ListNode temp = head;
            head = head.next;
            if (count - k - 1 == i) {
                temp.next = null;
            }
        }

        return head;
    }
}
