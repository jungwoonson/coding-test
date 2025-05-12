package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveDuplicatesFromSortedArrayTest {

    @ParameterizedTest
    @MethodSource("data")
    void duplicateZeros(int[] nums, int[] expectedArray, int expectedCount) {
        int count = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        assertThat(nums).isEqualTo(expectedArray);
        assertThat(count).isEqualTo(expectedCount);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2, 2}, 2),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4}, 5)
        );
    }
}