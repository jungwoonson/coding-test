package reetcode.hashtable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HappyNumberTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(int n, boolean expected) {
        boolean actual = new HappyNumber().isHappy(n);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false)
        );
    }
}
