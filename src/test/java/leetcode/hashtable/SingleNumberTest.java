package leetcode.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SingleNumberTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int expected) {
        int actual = new SingleNumber().singleNumber(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
                Arguments.of(new int[]{1}, 1)
        );
    }
}
