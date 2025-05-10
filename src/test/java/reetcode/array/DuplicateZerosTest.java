package reetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateZerosTest {

    @ParameterizedTest
    @MethodSource("data")
    void duplicateZeros(int[] arr, int[] expected) {
        new DuplicateZeros().duplicateZerosOptimal(arr);
        assertThat(arr).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {1,0,2,3,0,4,5,0}, new int[] {1,0,0,2,3,0,0,4}),
                Arguments.of(new int[] {1,2,3}, new int[] {1,2,3})
        );
    }
}