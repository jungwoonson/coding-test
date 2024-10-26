package beakjoon.no009리스트;

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

class No1406Test {

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
                Arguments.of("abcd" + NL
                        + "3" + NL
                        + "P x" + NL
                        + "L" + NL
                        + "P y",
                    "abcdyx"),
                Arguments.of("abc" + NL
                        + "9" + NL
                        + "L" + NL
                        + "L" + NL
                        + "L" + NL
                        + "L" + NL
                        + "L" + NL
                        + "P x" + NL
                        + "L" + NL
                        + "B" + NL
                        + "P y",
                    "yxabc"),
                    Arguments.of("dmih" + NL
                            + "11" + NL
                            + "B" + NL
                            + "B" + NL
                            + "P x" + NL
                            + "L" + NL
                            + "B" + NL
                            + "B" + NL
                            + "B" + NL
                            + "P y" + NL
                            + "D" + NL
                            + "D" + NL
                            + "P z",
                        "yxz")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No1406.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}