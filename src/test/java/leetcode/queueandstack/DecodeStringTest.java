package leetcode.queueandstack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DecodeStringTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(String s, String expected) {
        String actual = new DecodeString().decodeString(s);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("3[a]2[bc]", "aaabcbc"),
                Arguments.of("3[a2[c]]", "accaccacc"),
                Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }
}
