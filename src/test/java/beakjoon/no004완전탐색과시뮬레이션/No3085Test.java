package beakjoon.no004완전탐색과시뮬레이션;

import beakjoon.InOutputUtil;
import beakjoon.no004완전탐색과시뮬레이션.No3085;
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

class No3085Test {

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
                Arguments.of("3" + NL + "CCP" + NL + "CCP" + NL + "PPC", "3"),
                Arguments.of("4" + NL + "PPPP" + NL + "CYZY" + NL + "CCPY" + NL + "PPCC", "4"),
                Arguments.of("5" + NL + "YCPZY" + NL + "CYZZP" + NL + "CCPPP" + NL + "YCYZC" + NL + "CPPZZ", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No3085.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}
