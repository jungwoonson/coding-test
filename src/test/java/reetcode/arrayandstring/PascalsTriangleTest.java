package reetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PascalsTriangleTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int numRows, List<List<Integer>> expected) {
        List<List<Integer>> actual = new PascalsTriangle().generate(numRows);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(5, List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1),
                        List.of(1, 4, 6, 4, 1))
                ),
                Arguments.of(1, List.of(List.of(1)))
        );
    }
}