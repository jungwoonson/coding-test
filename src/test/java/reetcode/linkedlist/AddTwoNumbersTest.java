package reetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersTest {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),
                Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9},
                        new int[]{8, 9, 9, 9, 0, 0, 0, 1}),
                Arguments.of(new int[]{1, 6, 0, 3, 3, 6, 7, 2, 0, 1},
                        new int[]{6, 3, 0, 8, 9, 6, 6, 9, 6, 1},
                        new int[]{7, 9, 0, 1, 3, 3, 4, 2, 7, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] listValues1, int[] listValues2, int[] expectedValues) {
        ListNode list1 = createListNode(listValues1);
        ListNode list2 = createListNode(listValues2);

        ListNode actual = new AddTwoNumbers().addTwoNumbers(list1, list2);

        ListNode current = actual;
        for (int value : expectedValues) {
            assertThat(current.val).isEqualTo(value);
            current = current.next;
        }
    }

    private ListNode createListNode(int[] values) {
        ListNode head = null;
        if (values != null) {
            head = new ListNode(values[0]);
            ListNode current = head;
            for (int i = 1; i < values.length; i++) {
                ListNode next = new ListNode(values[i]);
                current.next = next;
                current = next;
            }
        }
        return head;
    }
}