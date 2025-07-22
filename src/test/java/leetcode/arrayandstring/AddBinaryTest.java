package leetcode.arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddBinaryTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(String a, String b, String expected) {
        String actual = new AddBinary().addBinary(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101")
        );
    }
}