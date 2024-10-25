package beakjoon.no009리스트;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MyArrayList 테스트")
class MyArrayListTest {

    private MyArrayList<Integer> list;
    private static final int ZERO_INDEX_ELEMENT = 10;
    private static final int ONE_INDEX_ELEMENT = 20;
    private static final int TWO_INDEX_ELEMENT = 30;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
        list.add(ZERO_INDEX_ELEMENT);
        list.add(ONE_INDEX_ELEMENT);
        list.add(TWO_INDEX_ELEMENT);
    }

    @DisplayName("크기 함수는, 현재 저장된 요소의 개수를 반환한다.")
    @Test
    void size() {
        // when
        list.add(0);
        // then
        assertThat(list.size()).isEqualTo(4);
    }

    @DisplayName("추가 함수는, 배열 맨 뒤에 요소를 추가한다.")
    @Test
    void add() {
        // given
        Integer element = 0;
        // when
        list.add(element);
        // then
        int lastIndex = list.size() - 1;
        assertThat(list.get(lastIndex)).isEqualTo(element);
    }

    @DisplayName("조회 함수는, 해당 인덱스의 요소를 반환한다.")
    @Test
    void get() {
        // when
        Integer actual = list.get(1);
        // then
        assertThat(actual).isEqualTo(ONE_INDEX_ELEMENT);
    }

    @DisplayName("조회 함수는, 배열 인덱스 범위를 벗어난 수를 입력하면 예외를 던진다.")
    @Test
    void get_out_of_bound() {
        // when
        ThrowingCallable callable = () -> list.get(3);
        // then
        assertThatThrownBy(callable).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("수정 함수는, 해당 인덱스의 요소를 입력된 요소로 바꾼다.")
    @Test
    void set() {
        // given
        Integer element = 100;
        // when
        list.set(1, element);
        // then
        assertThat(list.get(1)).isEqualTo(element);
    }

    @DisplayName("수정 함수는, 배열 인덱스 범위를 벗어난 수를 입력하면 예외를 던진다.")
    @Test
    void set_out_of_bound() {
        // when
        ThrowingCallable callable = () -> list.set(3, 100);
        // then
        assertThatThrownBy(callable).isInstanceOf(IndexOutOfBoundsException.class);
    }


    @DisplayName("삽입 함수는, 해당 인덱스에 요소를 추가하고 뒤의 요소들을 한 칸씩 뒤로 밀어낸다.")
    @Test
    void insert() {
        // given
        Integer element = 100;
        // when
        list.insert(1, element);
        // then
        assertThat(list.get(1)).isEqualTo(element);
        assertThat(list.get(2)).isEqualTo(ONE_INDEX_ELEMENT);
        assertThat(list.get(3)).isEqualTo(TWO_INDEX_ELEMENT);
    }

    @DisplayName("삭제 함수는, 해당 인덱스의 요소를 삭제하고 뒤의 요소들을 한 칸씩 앞으로 당긴다.")
    @Test
    void remove() {
        // given
        int size = list.size();
        // when
        list.remove(0);
        // then
        assertThat(list.size()).isEqualTo(size - 1);
        assertThat(list.get(0)).isEqualTo(ONE_INDEX_ELEMENT);
        assertThat(list.get(1)).isEqualTo(TWO_INDEX_ELEMENT);
    }

    @DisplayName("삭제 함수는, 배열 인덱스 범위를 벗어난 수를 입력하면 예외를 던진다.")
    @Test
    void remove_out_of_bound() {
        // when
        ThrowingCallable callable = () -> list.remove(3);
        // then
        assertThatThrownBy(callable).isInstanceOf(IndexOutOfBoundsException.class);
    }
}