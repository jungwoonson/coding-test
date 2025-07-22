package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OddEvenLinkedListTest {

    @Test
    void test1() {
        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node0 = new ListNode(1, node1);

        ListNode actual = new OddEvenLinkedList().oddEvenList(node0);

        check(actual, new int[]{1, 3, 5, 2, 4});
    }

    @Test
    void test2() {
        ListNode node6 = new ListNode(7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(6, node5);
        ListNode node3 = new ListNode(5, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node0 = new ListNode(2, node1);

        ListNode actual = new OddEvenLinkedList().oddEvenList(node0);

        check(actual, new int[]{2, 3, 6, 7, 1, 5, 4});
    }

    private static void check(ListNode actual, int[] expectedValues) {
        ListNode current = actual;
        for (int value : expectedValues) {
            assertThat(current.val).isEqualTo(value);
            current = current.next;
        }
    }
}