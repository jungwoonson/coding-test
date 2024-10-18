package beakjoon.no008투포인터;

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

class No2118Test {

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
                Arguments.of("5" + NL
                        + "1" + NL
                        + "2" + NL
                        + "3" + NL
                        + "4" + NL
                        + "5",
                        "7"),
            Arguments.of("2" + NL
                    + "5" + NL
                    + "3",
                "3"),
            Arguments.of("3" + NL
                    + "5" + NL
                    + "4" + NL
                    + "2",
                "5")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No2118.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}