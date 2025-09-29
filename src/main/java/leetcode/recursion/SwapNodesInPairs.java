package leetcode.recursion;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        return recursion(head, null);
    }

    public ListNode recursion(ListNode head, ListNode before) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next.next;
        ListNode newHead = head.next;
        if (before != null) {
            before.next = newHead;
        }
        newHead.next = head;
        head.next = next;
        recursion(head.next, head);
        return newHead;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
