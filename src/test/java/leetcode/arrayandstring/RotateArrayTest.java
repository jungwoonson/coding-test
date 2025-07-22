package leetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RotateArrayTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int k, int[] expected) {
        new RotateArray().rotate(nums, k);
        assertThat(nums).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}),
                Arguments.of(new int[]{-1}, 2, new int[]{-1})
        );
    }
}