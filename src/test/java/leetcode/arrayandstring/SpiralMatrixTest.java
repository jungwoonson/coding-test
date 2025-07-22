package leetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SpiralMatrixTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[][] mat, List<Integer> expected) {
        List<Integer> actual = new SpiralMatrix().spiralOrder(mat);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Arguments.of(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
                Arguments.of(new int[][]{{3}, {2}},
                        List.of(3, 2))
        );
    }
}