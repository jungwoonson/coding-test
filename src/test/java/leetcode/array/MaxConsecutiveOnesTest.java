package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaxConsecutiveOnesTest {

    @ParameterizedTest
    @MethodSource("data")
    void duplicateZeros(int[] num, int expected) {
        int actual = new MaxConsecutiveOnes().findMaxConsecutiveOnes(num);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, 3),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1}, 2)
        );
    }
}