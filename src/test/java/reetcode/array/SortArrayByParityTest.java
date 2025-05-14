package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortArrayByParityTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] nums, int[] expected) {
        int[] actual = new SortArrayByParity().sortArrayByParity(nums);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 4}, new int[]{2, 4, 1, 3}),
                Arguments.of(new int[]{0}, new int[]{0})
        );
    }
}