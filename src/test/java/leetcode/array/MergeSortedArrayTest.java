package leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedArrayTest {

    @ParameterizedTest
    @MethodSource("data")
    void duplicateZeros(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        new MergeSortedArray().merge(nums1, m, nums2, n);
        assertThat(nums1).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3, new int[] {1,2,2,3,5,6}),
                Arguments.of(new int[] {0}, 0, new int[] {1}, 1, new int[] {1})
        );
    }
}