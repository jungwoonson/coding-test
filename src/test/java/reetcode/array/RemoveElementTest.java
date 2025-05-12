package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveElementTest {

    @ParameterizedTest
    @MethodSource("data")
    void duplicateZeros(int[] nums, int val, int[] expectedArray, int expectedCount) {
        int count = new RemoveElement().removeElement(nums, val);
        assertThat(nums).isEqualTo(expectedArray);
        assertThat(count).isEqualTo(expectedCount);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2, 2, 3}, 2),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 1, 3, 0, 4, 0, 4, 2}, 5)
        );
    }
}