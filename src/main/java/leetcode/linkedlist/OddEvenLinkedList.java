package leetcode.linkedlist;

public class OddEvenLinkedList {

    // Constraints:
    // The number of nodes in the linked list is in the range [0, 10^4].
    // -10^6 <= Node.val <= 10^6
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode lastOddCountNode = null;
        int count = 0;
        while (current != null) {
            count++;
            if (count % 2 != 0) {
                lastOddCountNode = current;
            }
            current = current.next;
        }

        count = 0;
        current = new ListNode(0, head);
        ListNode connectingPart = lastOddCountNode;
        while (current.next != lastOddCountNode) {
            count++;
            if (count % 2 == 0) {
                 ListNode currentNext = current.next;
                 ListNode connectingNext = connectingPart.next;

                 current.next = current.next.next;
                 connectingPart.next = currentNext;
                 connectingPart.next.next = connectingNext;
                 connectingPart = connectingPart.next;
                 continue;
            }
            current = current.next;
        }

        return head;
    }

    // 홀수와 짝수를 각각 모아서 마지막에 붙여주는 방법이 가장 빠른 방법이다...
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}
