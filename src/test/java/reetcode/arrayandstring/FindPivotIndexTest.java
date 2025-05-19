package reetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import reetcode.array.CheckIfNAndItsDoubleExist;

class FindPivotIndexTest {
    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int expected) {
        int actual = new FindPivotIndex().pivotIndex(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{2, 1, -1}, 0)
        );
    }
}