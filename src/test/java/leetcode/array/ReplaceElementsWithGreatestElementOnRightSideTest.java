package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReplaceElementsWithGreatestElementOnRightSideTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] arr, int[] expected) {
        int[] actual = new ReplaceElementsWithGreatestElementOnRightSide().replaceElements(arr);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {17,18,5,4,6,1}, new int[] {18,6,6,6,1,-1}),
                Arguments.of(new int[] {400}, new int[] {-1})
        );
    }
}