package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] listValues1, int[] listValues2, int[] expectedValues) {
        ListNode list1 = createListNode(listValues1);
        ListNode list2 = createListNode(listValues2);

        ListNode actual = new MergeTwoSortedLists().mergeTwoLists(list1, list2);

        if (list1 == null && list2 == null) {
            assertThat(actual).isNull();
            return;
        }
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

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(null, null, null),
                Arguments.of(null, new int[]{0}, new int[]{0})
        );
    }
}