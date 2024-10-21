package beakjoon.no008투포인터;

import static beakjoon.InOutputUtil.NL;
import static org.assertj.core.api.Assertions.assertThat;

import beakjoon.InOutputUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class No17609Test {

    public final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("8" + NL
                    + "abba" + NL
                    + "summuus" + NL
                    + "xabba" + NL
                    + "xabbay" + NL
                    + "comcom" + NL
                    + "comwwmoc" + NL
                    + "comwwtmoc" + NL
                    + "abc",
                "0" + NL
                    + "1" + NL
                    + "1" + NL
                    + "2" + NL
                    + "2" + NL
                    + "0" + NL
                    + "1" + NL
                    + "2"),
            Arguments.of("1" + NL
                    + "bcabc",
                "2"),
            Arguments.of("1" + NL
                    + "abbab",
                "1")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No17609.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}