package reetcode.linkedlist;

public class AddTwoNumbers {

    // Constraints:
    // The number of nodes in each linked list is in the range [1, 100].
    // 0 <= Node.val <= 9
    // It is guaranteed that the list represents a number that does not have leading zeros.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }

        ListNode l1Next = null;
        if (l1 != null) {
            l1Next = l1.next;
        }
        ListNode l2Next = null;
        if (l2 != null) {
            l2Next = l2.next;
        }

        return new ListNode(sum % 10, addTwoNumbers(l1Next, l2Next, sum / 10));
    }
}
