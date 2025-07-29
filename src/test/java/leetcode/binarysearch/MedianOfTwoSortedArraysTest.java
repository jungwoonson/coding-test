package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MedianOfTwoSortedArraysTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums1, int[] nums2, double expected) {
        double actual = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                 Arguments.of(new int[]{}, new int[]{1, 2}, 1.5)
        );
    }
}
