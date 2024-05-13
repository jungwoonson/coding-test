package beakjoon.no003배열;

import beakjoon.InOutputUtil;
import beakjoon.no003배열.No3273;
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

public class No3273Test {

    public final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @ParameterizedTest
    @MethodSource("data")
    void answer(String n, String numbers, String x, String expected) throws IOException {
        InOutputUtil.setIn(n + NL + numbers + NL + x + NL);

        No3273.answer();
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("9", "5 12 7 10 9 1 2 3 11", "13", "3"),
                Arguments.of("10", "1 2 3 4 5 6 7 8 9 10", "10", "4")
        );
    }
}