package beakjoon.no006누적합배열과구간합;

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

class No16713_1Test {

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
                Arguments.of("5 3" + NL + "4 4 4 4 4" + NL + "1 1" + NL + "1 2" + NL + "1 3",
                        "0"),
                Arguments.of("5 4" + NL + "4 4 2 1 0" + NL + "1 1" + NL + "1 2" + NL + "1 3" + NL + "2 4",
                        "1")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No16713_1.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}