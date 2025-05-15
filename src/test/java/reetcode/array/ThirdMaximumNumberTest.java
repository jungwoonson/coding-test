package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ThirdMaximumNumberTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int expected) {
        int actual = new ThirdMaximumNumber().thirdMax(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{2, 2, 3, 1}, 1)
        );
    }
}