package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LinkedListCycle2Test {

    @Test
    void test1() {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        LinkedListCycle2 linkedListCycle2 = new LinkedListCycle2();

        ListNode actual = linkedListCycle2.detectCycle(node0);

        assertThat(actual).isEqualTo(node1);
    }

    @Test
    void test2() {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node0.next = node1;
        node1.next = node0;
        LinkedListCycle2 linkedListCycle2 = new LinkedListCycle2();

        ListNode actual = linkedListCycle2.detectCycle(node0);

        assertThat(actual).isEqualTo(node0);
    }

    @Test
    void test3() {
        ListNode node0 = new ListNode(3);
        LinkedListCycle2 linkedListCycle2 = new LinkedListCycle2();

        ListNode actual = linkedListCycle2.detectCycle(node0);

        assertThat(actual).isEqualTo(null);
    }
}