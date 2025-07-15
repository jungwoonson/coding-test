package reetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchInRotatedSortedArrayTest {

    @DisplayName("최소 값의 인덱스를 찾는다.")
    @ParameterizedTest
    @MethodSource("data1")
    void test(int[] nums, int expected) {
        int actual = new SearchInRotatedSortedArray().findMinIndex(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data1() {
        return Stream.of(
                Arguments.of(new int[]{5, 6, 7, 8, 1, 2, 3, 4}, 4),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{2, 1}, 1),
                Arguments.of(new int[]{2, 3, 1}, 2),
                Arguments.of(new int[]{2, 3, 4, 5, 6, 1}, 5),
                Arguments.of(new int[]{1, 2}, 0),
                Arguments.of(new int[]{3, 1}, 1)
        );
    }

    @DisplayName("target의 index를 찾는다. 없으면 -1을 리턴한다.")
    @ParameterizedTest
    @MethodSource("data2")
    void tes2(int[] nums, int target, int expected) {
        int actual = new SearchInRotatedSortedArray().search(nums, target);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data2() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{3, 1}, 3, 0)
        );
    }
}
