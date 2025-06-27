package reetcode.queueandstack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(String s, boolean expected) {
        boolean actual = new ValidParentheses().isValid(s);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([])", true)
        );
    }
}
