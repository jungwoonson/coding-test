package reetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlusOneTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int[] expected) {
        int[] actual = new PlusOne().plusOne(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.of(new int[]{9}, new int[]{1, 0}),
                Arguments.of(new int[]{9, 9}, new int[]{1, 0, 0}),
                Arguments.of(new int[]{1, 9}, new int[]{2, 0}),
                Arguments.of(new int[]{5, 6, 2, 0, 0, 4, 6, 2, 4, 9}, new int[]{5, 6, 2, 0, 0, 4, 6, 2, 5, 0})
        );
    }
}