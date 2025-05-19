package reetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LargestNumberAtLeastTwiceOfOthersTest {
    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int expected) {
        int actual = new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 1, 0}, 1),
                Arguments.of(new int[]{1, 2, 3, 4}, -1),
                Arguments.of(new int[]{0, 0, 3, 2}, -1)
        );
    }
}