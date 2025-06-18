package reetcode.queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyCircularQueueTest {

    @DisplayName("isEmpty 함수는, queue가 비어있으면 true를 반환한다.")
    @Test
    void isEmptyTrueTest() {
        MyCircularQueue queue = new MyCircularQueue(3);

        boolean actual = queue.isEmpty();

        assertThat(actual).isTrue();
    }

    @DisplayName("isEmpty 함수는, queue가 비어있지 않으면 false를 반환한다.")
    @Test
    void isEmptyFalseTest() {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);

        boolean actual = queue.isEmpty();

        assertThat(actual).isFalse();
    }

    @DisplayName("isFull 함수는, queue가 가득차있으면 true를 반환한다.")
    @Test
    void isFullTrueTest() {
        MyCircularQueue queue = new MyCircularQueue(2);
        queue.enQueue(1);
        queue.enQueue(2);

        boolean actual = queue.isFull();

        assertThat(actual).isTrue();
    }

    @DisplayName("isFull 함수는, queue가 가득차있지 않으면 false를 반환한다.")
    @Test
    void isFullFalseTest() {
        MyCircularQueue queue = new MyCircularQueue(2);
        queue.enQueue(1);

        boolean actual = queue.isFull();

        assertThat(actual).isFalse();
    }
}