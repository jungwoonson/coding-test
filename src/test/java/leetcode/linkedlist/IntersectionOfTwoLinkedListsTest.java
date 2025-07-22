package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IntersectionOfTwoLinkedListsTest {

    @Test
    void test1() {
        ListNode intersectVal = new ListNode(8);
        ListNode listA = createList(new int[]{4, 1, 8, 4, 5}, 2, intersectVal);
        ListNode listB = createList(new int[]{5, 6, 1, 8, 4, 5}, 3, intersectVal);

        ListNode actual = new IntersectionOfTwoLinkedLists().getIntersectionNode(listA, listB);

        assertThat(actual).isEqualTo(intersectVal);
    }

    @Test
    void test2() {
        ListNode intersectVal = new ListNode(2);
        ListNode listA = createList(new int[]{1, 9, 1, 2, 4}, 3, intersectVal);
        ListNode listB = createList(new int[]{3, 2, 4}, 1, intersectVal);

        ListNode actual = new IntersectionOfTwoLinkedLists().getIntersectionNode(listA, listB);

        assertThat(actual).isEqualTo(intersectVal);
    }

    @Test
    void test3() {
        ListNode intersectVal = new ListNode(0);
        ListNode listA = createList(new int[]{2, 6, 4}, 3, intersectVal);
        ListNode listB = createList(new int[]{1, 5}, 2, intersectVal);

        ListNode actual = new IntersectionOfTwoLinkedLists().getIntersectionNode(listA, listB);

        assertThat(actual).isNull();
    }

    private ListNode createList(int[] values, int skip, ListNode intersectNode) {
        ListNode head = new ListNode(values[0]);
        if (skip == 0) {
            head = intersectNode;
        }
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            if (i == skip) {
                current.next = intersectNode;
                current = current.next;
                continue;
            }
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }
}