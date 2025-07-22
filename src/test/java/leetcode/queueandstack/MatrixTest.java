package leetcode.queueandstack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[][] image, int[][] expected) {
        int[][] actual = new Matrix().updateMatrix(image);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}},
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}}),
                Arguments.of(
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 1, 1}},
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 2, 1}})
        );
    }
}
