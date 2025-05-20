package reetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiagonalTraverseTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[][] mat, int[] expected) {
        int[] actual = new DiagonalTraverse().findDiagonalOrder(mat);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2, 3, 4})
        );
    }
}