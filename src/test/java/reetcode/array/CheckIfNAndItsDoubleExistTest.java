package reetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CheckIfNAndItsDoubleExistTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int[] arr, boolean expected) {
        boolean actual = new CheckIfNAndItsDoubleExist().checkIfExist(arr);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {10,2,5,3}, true),
                Arguments.of(new int[] {3,1,7,11}, false)
        );
    }
}