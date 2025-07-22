package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndOfListTest {

    @Test
    void test1() {
        int[] values = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = createList(values);

        ListNode actual = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);

        checks(actual, new int[]{1, 2, 3, 5}, values.length, values.length - n);
    }

    @Test
    void test2() {
        int[] values = {1};
        ListNode head = createList(values);

        ListNode actual = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);

        assertThat(actual).isNull();
    }

    @Test
    void test3() {
        int[] values = {1, 2};
        int n = 1;
        ListNode head = createList(values);

        ListNode actual = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);

        checks(actual, new int[]{1, 2, 3, 5}, values.length, values.length - n);
    }

    @Test
    void test4() {
        int[] values = {1, 2};
        int n = 2;
        ListNode head = createList(values);

        ListNode actual = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);

        checks(actual, new int[]{2}, values.length, values.length - n);
    }

    private ListNode createList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    private void checks(ListNode actual, int[] expected, int size, int index) {
        ListNode current = actual;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                continue;
            }
            assertThat(current.val).isEqualTo(expected[count++]);
            current = current.next;
        }
    }
}