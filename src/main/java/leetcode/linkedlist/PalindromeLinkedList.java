package leetcode.linkedlist;

public class PalindromeLinkedList {

    // Constraints:
    // The number of nodes in the list is in the range [1, 10^5].
    // 0 <= Node.val <= 9
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = new ListNode(0, head);
        ListNode right = new ListNode(0, prev);
        while (left.next != null && right.next != null) {
            if (left.next.val != right.next.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
