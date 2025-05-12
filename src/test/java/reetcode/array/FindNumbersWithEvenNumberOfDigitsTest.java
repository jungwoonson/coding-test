package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindNumbersWithEvenNumberOfDigitsTest {

    @ParameterizedTest
    @MethodSource("data")
    void duplicateZeros(int[] num, int expected) {
        int actual = new FindNumbersWithEvenNumberOfDigits().findNumbers(num);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{12, 345, 2, 6, 7896}, 2),
                Arguments.of(new int[]{555, 901, 482, 1771}, 1)
        );
    }
}