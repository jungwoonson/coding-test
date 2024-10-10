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

class No6236Test {

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
                Arguments.of("7 5" + NL +
                                "100" + NL +
                                "400" + NL +
                                "300" + NL +
                                "100" + NL +
                                "500" + NL +
                                "101" + NL +
                                "400",
                        "500"),
                Arguments.of("2 1" + NL +
                                "100" + NL +
                                "700",
                        "800"),
                Arguments.of("3 3" + NL +
                                "800" + NL +
                                "100" + NL +
                                "300",
                        "800")
                // 1200
                // 600

                // 1 600 count 1
                // 2 500 count 1
                // 3 200 count 1
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No6236.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}