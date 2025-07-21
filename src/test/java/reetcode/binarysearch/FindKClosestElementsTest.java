package reetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindKClosestElementsTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] arr, int k, int x, List<Integer> expected) {
        List<Integer> actual = new FindKClosestElements().findClosestElements(arr, k, x);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                 Arguments.of(new int[]{0, 2, 2, 3, 4, 6, 7, 8, 9, 9}, 4, 5, List.of(3, 4, 6, 7)),
                Arguments.of(new int[]{1, 1, 2, 2, 2, 2, 2, 3, 3}, 3, 3, List.of(2, 3, 3))
        );
    }
}
