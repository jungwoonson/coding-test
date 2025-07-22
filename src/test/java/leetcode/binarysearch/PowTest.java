package leetcode.binarysearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PowTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(double x, int n, double expected) {
        double actual = new Pow().myPow(x, n);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                 Arguments.of(2.0, 10, 1024.0),
                 Arguments.of(2.0, -2, 0.25),
                 Arguments.of(0.00001, 2147483647, 0.0)
        );
    }
}
