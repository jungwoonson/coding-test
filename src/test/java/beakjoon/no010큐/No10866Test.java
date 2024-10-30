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

class No10866Test {

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
                Arguments.of("15" + NL
                        + "push_back 1" + NL
                        + "push_front 2" + NL
                        + "front" + NL
                        + "back" + NL
                        + "size" + NL
                        + "empty" + NL
                        + "pop_front" + NL
                        + "pop_back" + NL
                        + "pop_front" + NL
                        + "size" + NL
                        + "empty" + NL
                        + "pop_back" + NL
                        + "push_front 3" + NL
                        + "empty" + NL
                        + "front",
                        "2" + NL
                            + "1" + NL
                            + "2" + NL
                            + "0" + NL
                            + "2" + NL
                            + "1" + NL
                            + "-1" + NL
                            + "0" + NL
                            + "1" + NL
                            + "-1" + NL
                            + "0" + NL
                            + "3"),
            Arguments.of("22" + NL
                    + "front" + NL
                    + "back" + NL
                    + "pop_front" + NL
                    + "pop_back" + NL
                    + "push_front 1" + NL
                    + "front" + NL
                    + "pop_back" + NL
                    + "push_back 2" + NL
                    + "back" + NL
                    + "pop_front" + NL
                    + "push_front 10" + NL
                    + "push_front 333" + NL
                    + "front" + NL
                    + "back" + NL
                    + "pop_back" + NL
                    + "pop_back" + NL
                    + "push_back 20" + NL
                    + "push_back 1234" + NL
                    + "front" + NL
                    + "back" + NL
                    + "pop_back" + NL
                    + "pop_back",
                "-1" + NL
                    + "-1" + NL
                    + "-1" + NL
                    + "-1" + NL
                    + "1" + NL
                    + "1" + NL
                    + "2" + NL
                    + "2" + NL
                    + "333" + NL
                    + "10" + NL
                    + "10" + NL
                    + "333" + NL
                    + "20" + NL
                    + "1234" + NL
                    + "1234" + NL
                    + "20")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No10866.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}