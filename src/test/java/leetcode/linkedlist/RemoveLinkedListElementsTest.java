package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RemoveLinkedListElementsTest {

    @Test
    void test1() {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node0 = new ListNode(1, node1);

        ListNode actual = new RemoveLinkedListElements().removeElements(node0, 6);

        int[] expectedValues = {1, 2, 3, 4, 5};
        ListNode current = actual;
        for (int value : expectedValues) {
            assertThat(current.val).isEqualTo(value);
            current = current.next;
        }
    }

    @Test
    void test2() {
        ListNode actual = new RemoveLinkedListElements().removeElements(null, 1);

        assertThat(actual).isNull();
    }

    @Test
    void test3() {
        ListNode node3 = new ListNode(7);
        ListNode node2 = new ListNode(7, node3);
        ListNode node1 = new ListNode(7, node2);
        ListNode node0 = new ListNode(7, node1);

        ListNode actual = new RemoveLinkedListElements().removeElements(node0, 7);

        assertThat(actual).isNull();
    }
}