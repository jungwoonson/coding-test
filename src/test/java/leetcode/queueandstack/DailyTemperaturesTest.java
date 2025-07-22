package leetcode.queueandstack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DailyTemperaturesTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] temperatures, int[] expected) {
        int[] actual = new DailyTemperatures().dailyTemperatures(temperatures);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73},
                        new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                Arguments.of(new int[]{30, 40, 50, 60},
                        new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{30, 60, 90},
                        new int[]{1, 1, 0})
        );
    }
}
