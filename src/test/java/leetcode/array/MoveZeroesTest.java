package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] num, int[] expected) {
        new MoveZeroes().moveZeroes2(num);
        assertThat(num).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 0}, new int[]{1, 0})
        );
    }
}