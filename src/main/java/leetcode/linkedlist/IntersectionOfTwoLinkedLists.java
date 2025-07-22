package leetcode.linkedlist;

public class IntersectionOfTwoLinkedLists {

    // Constraints:
    // The number of nodes of listA is in the m.
    // The number of nodes of listB is in the n.
    // 1 <= m, n <= 3 * 10^4
    // 1 <= Node.val <= 10^5
    // 0 <= skipA <= m
    // 0 <= skipB <= n
    // intersectVal is 0 if listA and listB do not intersect.
    // intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

    // 1 2 3 4 5 6 7 8
    // 6 7 8 1 2 3 4 5
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }

        return currA;
    }
}
