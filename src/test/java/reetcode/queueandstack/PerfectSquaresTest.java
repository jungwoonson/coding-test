package reetcode.queueandstack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PerfectSquaresTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int n, int expected) {
        int actual = new PerfectSquares().numSquares(n);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(13, 2)
        );
    }
}
