package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidMountainArrayTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] arr, boolean expected) {
        boolean actual = new ValidMountainArray().validMountainArray(arr);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {2,1}, false),
                Arguments.of(new int[] {3,5,5}, false),
                Arguments.of(new int[] {0,3,2,1}, true),
                Arguments.of(new int[] {2}, false)
        );
    }
}