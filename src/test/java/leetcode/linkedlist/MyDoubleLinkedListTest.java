package leetcode.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MyDoubleLinkedListTest {

    private MyDoubleLinkedList myLinkedList;

    @BeforeEach
    void setUp() {
        myLinkedList = new MyDoubleLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
    }

    @DisplayName("get 함수는, 인덱스가 유효한 경우 해당 값을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3"})
    void getTest(int index, int value) {
        int actual = myLinkedList.get(index);

        assertThat(actual).isEqualTo(value);
    }

    @DisplayName("get 함수는, 유효하지 않은 인덱스에 대해 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource("-1,3")
    void getNotInvalidIndexTest(int index) {
        ThrowingCallable actual = () -> myLinkedList.get(index);

        assertThatThrownBy(actual).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("addAtHead 함수는, 새로운 노드를 리스트의 맨 앞에 추가한다.")
    @Test
    void addAtHead() {
        int headValue = 4;

        myLinkedList.addAtHead(headValue);
        int actual = myLinkedList.get(0);

        assertThat(actual).isEqualTo(headValue);
    }

    @DisplayName("addAtTail 함수는, 새로운 노드를 리스트의 맨 뒤에 추가한다.")
    @Test
    void addAtTail() {
        int tailValue = 4;

        myLinkedList.addAtTail(tailValue);
        int actual = myLinkedList.get(3);

        assertThat(actual).isEqualTo(tailValue);
    }

    @DisplayName("addAtIndex 함수는, 유효한 인덱스에 새로운 노드를 추가한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,4", "1,4", "3,4"})
    void addAtIndex(int index, int value) {
        myLinkedList.addAtIndex(index, value);
        int actual = myLinkedList.get(index);

        assertThat(actual).isEqualTo(value);
    }

    @DisplayName("addAtIndex 함수는, 유효하지 않은 인덱스에 대해 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"-1,4", "4,4"})
    void addAtInvalidIndex(int index, int value) {
        ThrowingCallable actual = () -> myLinkedList.addAtIndex(index, value);

        assertThatThrownBy(actual).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("deleteAtIndex 함수는, 유효한 인덱스에 노드를 제거한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,2", "1,3"})
    void deleteAtIndex(int index, int expected) {
        myLinkedList.deleteAtIndex(index);
        int actual = myLinkedList.get(index);

        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("deleteAtIndex 함수는, 유효한 마지막 인덱스의 노드를 제거하고 해당 인덱스의 값을 가져오려하면 예외를 발생시킨다.")
    @Test
    void deleteAtTailIndex() {
        int tailIndex = 2;

        myLinkedList.deleteAtIndex(tailIndex);
        ThrowingCallable actual = () -> myLinkedList.get(tailIndex);

        assertThatThrownBy(actual).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("deleteAtIndex 함수는, 유효한 마지막 인덱스의 노드를 제거하고 해당 인덱스의 값을 가져오려하면 예외를 발생시킨다.")
    @Test
    void deleteAtEmptyNodeTest() {
        myLinkedList = new MyDoubleLinkedList();
        int index = 0;

        ThrowingCallable actual = () -> myLinkedList.deleteAtIndex(index);

        assertThatThrownBy(actual).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("deleteAtIndex 함수는, 유효하지 않은 인덱스에 대해 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"-1", "3"})
    void deleteAtInvalidIndex(int index) {
        ThrowingCallable actual = () -> myLinkedList.deleteAtIndex(index);

        assertThatThrownBy(actual).isInstanceOf(IndexOutOfBoundsException.class);
    }
}