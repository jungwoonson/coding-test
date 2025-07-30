package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindKthSmallestPairDistanceTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int k, int expected) {
        int actual = new FindKthSmallestPairDistance().smallestDistancePair(nums, k);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                 Arguments.of(new int[]{64, 100, 4}, 2, 60),
                 Arguments.of(new int[]{9,10,7,10,6,1,5,4,9,8}, 18, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("countData")
    void count(int[] nums, int k, int expected) {
        int actual = new FindKthSmallestPairDistance().count(nums, k);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> countData() {
        return Stream.of(
                Arguments.of(new int[]{4, 64, 100}, 60, 2)
        );
    }
}
