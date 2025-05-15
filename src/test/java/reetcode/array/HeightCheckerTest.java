package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HeightCheckerTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] heights, int expected) {
        int actual = new HeightChecker().heightChecker(heights);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 4, 2, 1, 3}, 3),
                Arguments.of(new int[]{5, 1, 2, 3, 4}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 0)
        );
    }
}