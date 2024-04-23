package beakjoon;

import static org.junit.jupiter.api.Assertions.*;

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

class No2840Test {

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
                Arguments.of("3 3" + NL + "1 A" + NL + "2 B" + NL + "3 C", "!"),
                Arguments.of("5 6" + NL + "1 A" + NL + "2 B" + NL + "5 B" + NL + "1 C" + NL + "2 A" + NL + "2 B", "B?A?C"),
                Arguments.of("8 8" + NL + "4 V" + NL + "3 I" + NL + "7 T" + NL + "7 A" + NL + "6 R" + NL + "5 N" + NL + "1 O" + NL + "9 H", "HONITAVR"),
                Arguments.of("2 2" + NL + "4 L" + NL + "4 A", "!")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No2840.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}