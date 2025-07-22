package leetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseWordsInAString3Test {

    @ParameterizedTest
    @MethodSource("data")
    void test(String s, String expected) {
        String actual = new ReverseWordsInAString3().reverseWords(s);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                Arguments.of("God Ding", "doG gniD")
        );
    }
}