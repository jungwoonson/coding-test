package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidPerfectSquareTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int num, boolean expected) {
        boolean actual = new ValidPerfectSquare().isPerfectSquare(num);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                 Arguments.of(14, false)
        );
    }
}
