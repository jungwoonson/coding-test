package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindAllNumbersDisappearedInAnArrayTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] arr, List<Integer> expected) {
        List<Integer> actual = new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(arr);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(5, 6)),
                Arguments.of(new int[]{1, 1}, List.of(2))
        );
    }
}