package reetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PascalTriangleTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int rowIndex, List<Integer> expected) {
        List<Integer> actual = new PascalTriangle().getRow2(rowIndex);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(3, List.of(1, 3, 3, 1)),
                Arguments.of(0, List.of(1)),
                Arguments.of(1, List.of(1, 1))
        );
    }
}