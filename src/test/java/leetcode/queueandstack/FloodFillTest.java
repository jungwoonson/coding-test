package leetcode.queueandstack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FloodFillTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[][] image, int sr, int sc, int color, int[][] expected) {
        int[][] actual = new FloodFill().floodFill(image, sr, sc, color);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 1, 1},
                                {1, 1, 0},
                                {1, 0, 1}},
                        1, 1, 2,
                        new int[][]{
                                {2, 2, 2},
                                {2, 2, 0},
                                {2, 0, 1}}),
                Arguments.of(
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0}},
                        0, 0, 0,
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0}})
        );
    }
}
