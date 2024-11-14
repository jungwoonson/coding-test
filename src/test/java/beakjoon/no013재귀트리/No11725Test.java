package beakjoon.no013재귀트리;

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

class No11725Test {

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
                Arguments.of("7" + NL
                        + "1 6" + NL
                        + "6 3" + NL
                        + "3 5" + NL
                        + "4 1" + NL
                        + "2 4" + NL
                        + "4 7",
                        "4" + NL
                            + "6" + NL
                            + "1" + NL
                            + "3" + NL
                            + "1" + NL
                            + "4"),
                Arguments.of("12" + NL
                        + "1 2" + NL
                        + "1 3" + NL
                        + "2 4" + NL
                        + "3 5" + NL
                        + "3 6" + NL
                        + "4 7" + NL
                        + "4 8" + NL
                        + "5 9" + NL
                        + "5 10" + NL
                        + "6 11" + NL
                        + "6 12",
                        "1" + NL
                            + "1" + NL
                            + "2" + NL
                            + "3" + NL
                            + "3" + NL
                            + "4" + NL
                            + "4" + NL
                            + "5" + NL
                            + "5" + NL
                            + "6" + NL
                            + "6")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No11725.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}