package beakjoon.no014재귀;

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

class No6603Test {

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
            Arguments.of("7 1 2 3 4 5 6 7" + NL
                    + "8 1 2 3 5 8 13 21 34" + NL
                    + "0",
                "1 2 3 4 5 6" + NL
                    + "1 2 3 4 5 7" + NL
                    + "1 2 3 4 6 7" + NL
                    + "1 2 3 5 6 7" + NL
                    + "1 2 4 5 6 7" + NL
                    + "1 3 4 5 6 7" + NL
                    + "2 3 4 5 6 7" + NL
                    + NL
                    + "1 2 3 5 8 13" + NL
                    + "1 2 3 5 8 21" + NL
                    + "1 2 3 5 8 34" + NL
                    + "1 2 3 5 13 21" + NL
                    + "1 2 3 5 13 34" + NL
                    + "1 2 3 5 21 34" + NL
                    + "1 2 3 8 13 21" + NL
                    + "1 2 3 8 13 34" + NL
                    + "1 2 3 8 21 34" + NL
                    + "1 2 3 13 21 34" + NL
                    + "1 2 5 8 13 21" + NL
                    + "1 2 5 8 13 34" + NL
                    + "1 2 5 8 21 34" + NL
                    + "1 2 5 13 21 34" + NL
                    + "1 2 8 13 21 34" + NL
                    + "1 3 5 8 13 21" + NL
                    + "1 3 5 8 13 34" + NL
                    + "1 3 5 8 21 34" + NL
                    + "1 3 5 13 21 34" + NL
                    + "1 3 8 13 21 34" + NL
                    + "1 5 8 13 21 34" + NL
                    + "2 3 5 8 13 21" + NL
                    + "2 3 5 8 13 34" + NL
                    + "2 3 5 8 21 34" + NL
                    + "2 3 5 13 21 34" + NL
                    + "2 3 8 13 21 34" + NL
                    + "2 5 8 13 21 34" + NL
                    + "3 5 8 13 21 34")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No6603.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}