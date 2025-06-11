package reetcode.linkedlist;

public class MergeTwoSortedLists {

    // Constraints:
    // The number of nodes in both lists is in the range [0, 50].
    // -100 <= Node.val <= 100
    // Both list1 and list2 are sorted in non-decreasing order.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
                continue;
            }
            if (list1.val < list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
                continue;
            }
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
        return head.next;
    }
}
