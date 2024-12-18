package beakjoon.no012재귀;

import beakjoon.InOutputUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.stream.Stream;

import static beakjoon.InOutputUtil.NL;
import static org.assertj.core.api.Assertions.assertThat;

class No15654Test {

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
                Arguments.of("3 1" + NL +
                                "4 5 2",
                        "2" + NL +
                                "4" + NL +
                                "5"),
                Arguments.of("4 2" + NL +
                                "9 8 7 1",
                        "1 7" + NL +
                                "1 8" + NL +
                                "1 9" + NL +
                                "7 1" + NL +
                                "7 8" + NL +
                                "7 9" + NL +
                                "8 1" + NL +
                                "8 7" + NL +
                                "8 9" + NL +
                                "9 1" + NL +
                                "9 7" + NL +
                                "9 8"),
                Arguments.of("4 4" + NL +
                                "1231 1232 1233 1234",
                        "1231 1232 1233 1234" + NL +
                                "1231 1232 1234 1233" + NL +
                                "1231 1233 1232 1234" + NL +
                                "1231 1233 1234 1232" + NL +
                                "1231 1234 1232 1233" + NL +
                                "1231 1234 1233 1232" + NL +
                                "1232 1231 1233 1234" + NL +
                                "1232 1231 1234 1233" + NL +
                                "1232 1233 1231 1234" + NL +
                                "1232 1233 1234 1231" + NL +
                                "1232 1234 1231 1233" + NL +
                                "1232 1234 1233 1231" + NL +
                                "1233 1231 1232 1234" + NL +
                                "1233 1231 1234 1232" + NL +
                                "1233 1232 1231 1234" + NL +
                                "1233 1232 1234 1231" + NL +
                                "1233 1234 1231 1232" + NL +
                                "1233 1234 1232 1231" + NL +
                                "1234 1231 1232 1233" + NL +
                                "1234 1231 1233 1232" + NL +
                                "1234 1232 1231 1233" + NL +
                                "1234 1232 1233 1231" + NL +
                                "1234 1233 1231 1232" + NL +
                                "1234 1233 1232 1231")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No15654.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}