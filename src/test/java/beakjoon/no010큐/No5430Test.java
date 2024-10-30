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

class No5430Test {

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
            Arguments.of("4" + NL
                    + "RDD" + NL
                    + "4" + NL
                    + "[1,2,3,4]" + NL
                    + "DD" + NL
                    + "1" + NL
                    + "[42]" + NL
                    + "RRD" + NL
                    + "6" + NL
                    + "[1,1,2,3,5,8]" + NL
                    + "D" + NL
                    + "0" + NL
                    + "[]",
                "[2,1]" + NL
                    + "error" + NL
                    + "[1,2,3,5,8]" + NL
                    + "error"),
            Arguments.of("1" + NL
                    + "RRRDD" + NL
                    + "2" + NL
                    + "[1,2]",
                "[]")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No5430.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}