package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {

    @Test
    void test1() {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode actual = new ReverseLinkedList().reverseList(node0);

        check(actual, new int[]{5, 4, 3, 2, 1});
    }

    @Test
    void test2() {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node0.next = node1;

        ListNode actual = new ReverseLinkedList().reverseList(node0);

        check(actual, new int[]{2, 1});
    }

    @Test
    void test3() {
        ListNode actual = new ReverseLinkedList().reverseList(null);

        assertThat(actual).isNull();
    }

    private void check(ListNode actual, int[] values) {
        ListNode current = actual;
        for (int value : values) {
            assertThat(current.val).isEqualTo(value);
            current = current.next;
        }
    }
}