package beakjoon.no007이분탐색;

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

class No14425Test {

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
                Arguments.of("5 11" + NL +
                        "baekjoononlinejudge" + NL +
                        "startlink" + NL +
                        "codeplus" + NL +
                        "sundaycoding" + NL +
                        "codingsh" + NL +
                        "baekjoon" + NL +
                        "codeplus" + NL +
                        "codeminus" + NL +
                        "startlink" + NL +
                        "starlink" + NL +
                        "sundaycoding" + NL +
                        "codingsh" + NL +
                        "codinghs" + NL +
                        "sondaycoding" + NL +
                        "startrink" + NL +
                        "icerink",
                        "4")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No14425_1.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}