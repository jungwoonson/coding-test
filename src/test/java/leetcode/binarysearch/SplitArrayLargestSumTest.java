package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SplitArrayLargestSumTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int k, int expected) {
        int actual = new SplitArrayLargestSum().splitArray(nums, k);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
       //          Arguments.of(new int[]{7, 2, 5, 10, 8}, 2, 18),
                 Arguments.of(new int[]{1, 4, 4}, 3, 4)
        );
    }
}
