package reetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LinkedListCycle2Test {

    @ParameterizedTest
    @MethodSource("data")
    void test(ListNode head, ListNode expected) {
        ListNode actual = new LinkedListCycle2().detectCycle(head);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(example1(), new ListNode(2)),
                Arguments.of(example2(), new ListNode(1)),
                Arguments.of(example3(), null)
        );
    }

    private static ListNode example1() {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

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