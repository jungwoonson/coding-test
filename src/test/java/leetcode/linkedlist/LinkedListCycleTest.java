package leetcode.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListCycleTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(ListNode head, boolean expected) {
        boolean actual = new LinkedListCycle().hasCycle(head);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(example1(), true),
                Arguments.of(example2(), true),
                Arguments.of(example3(), false)
        );
    }

    private static ListNode example1() {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        return node0;
    }

    private static ListNode example2() {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);

        node0.next = node1;
        node1.next = node0;

        return node0;
    }

    private static ListNode example3() {
        ListNode node0 = new ListNode(3);

        return node0;
    }
}