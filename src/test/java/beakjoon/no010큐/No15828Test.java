package beakjoon.no010큐;

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

class No15828Test {

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
                Arguments.of("5" + NL
                        + "1" + NL
                        + "2" + NL
                        + "0" + NL
                        + "3" + NL
                        + "4" + NL
                        + "0" + NL
                        + "5" + NL
                        + "6" + NL
                        + "0" + NL
                        + "0" + NL
                        + "-1",
                        "5 6"),
            Arguments.of("1" + NL
                    + "1" + NL
                    + "2" + NL
                    + "3" + NL
                    + "4" + NL
                    + "5" + NL
                    + "6" + NL
                    + "7" + NL
                    + "-1",
                "1"),
            Arguments.of("1" + NL
                    + "1" + NL
                    + "2" + NL
                    + "0" + NL
                    + "3" + NL
                    + "4" + NL
                    + "0" + NL
                    + "5" + NL
                    + "6" + NL
                    + "0" + NL
                    + "7" + NL
                    + "0" + NL
                    + "-1",
                "empty")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No15828.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}