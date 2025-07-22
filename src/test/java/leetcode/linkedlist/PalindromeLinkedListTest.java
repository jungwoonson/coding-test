package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PalindromeLinkedListTest {

    @Test
    void test1() {
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node0 = new ListNode(1, node1);

        boolean actual = new PalindromeLinkedList().isPalindrome(node0);

        assertThat(actual).isTrue();
    }

    @Test
    void test2() {
        ListNode node1 = new ListNode(2);
        ListNode node0 = new ListNode(1, node1);

        boolean actual = new PalindromeLinkedList().isPalindrome(node0);

        assertThat(actual).isFalse();
    }
}