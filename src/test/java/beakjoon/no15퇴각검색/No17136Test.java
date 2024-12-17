package beakjoon.no15퇴각검색;

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

class No17136Test {

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
//            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0",
//                "0"),
//            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 1 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 1 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 1 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 1 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0",
//                "4"),
            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
                    + "0 1 1 0 0 0 0 0 0 0" + NL
                    + "0 0 1 0 0 0 0 0 0 0" + NL
                    + "0 0 0 0 1 1 0 0 0 0" + NL
                    + "0 0 0 0 1 1 0 0 0 0" + NL
                    + "0 0 0 0 0 0 0 0 0 0" + NL
                    + "0 0 1 0 0 0 0 0 0 0" + NL
                    + "0 0 0 0 0 0 0 0 0 0" + NL
                    + "0 0 0 0 0 0 0 0 0 0" + NL
                    + "0 0 0 0 0 0 0 0 0 0",
                "5")
//            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 1 1 0 0 0 0 0 0 0" + NL
//                    + "0 0 1 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 1 1 0 0 0 0" + NL
//                    + "0 0 0 0 0 1 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 1 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0",
//                "-1"),
//            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 1 1 0 0 0 0 0 0 0" + NL
//                    + "0 1 1 1 0 0 0 0 0 0" + NL
//                    + "0 0 1 1 1 1 1 0 0 0" + NL
//                    + "0 0 0 1 1 1 1 0 0 0" + NL
//                    + "0 0 0 0 1 1 1 0 0 0" + NL
//                    + "0 0 1 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 0 0 0 0 0 0 0 0 0",
//                "7"),
//            Arguments.of("1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL
//                    + "1 1 1 1 1 1 1 1 1 1" + NL,
//                "4"),
//            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 1 1 1 1 1 0 0 0 0" + NL
//                    + "0 1 1 1 1 1 0 0 0 0" + NL
//                    + "0 0 1 1 1 1 0 0 0 0" + NL
//                    + "0 0 1 1 1 1 0 0 0 0" + NL
//                    + "0 1 1 1 1 1 1 1 1 1" + NL
//                    + "0 1 1 1 0 1 1 1 1 1" + NL
//                    + "0 1 1 1 0 1 1 1 1 1" + NL
//                    + "0 0 0 0 0 1 1 1 1 1" + NL
//                    + "0 0 0 0 0 1 1 1 1 1",
//                "6"),
//            Arguments.of("0 0 0 0 0 0 0 0 0 0" + NL
//                    + "1 1 1 1 1 0 0 0 0 0" + NL
//                    + "1 1 1 1 1 0 1 1 1 1" + NL
//                    + "1 1 1 1 1 0 1 1 1 1" + NL
//                    + "1 1 1 1 1 0 1 1 1 1" + NL
//                    + "1 1 1 1 1 0 1 1 1 1" + NL
//                    + "0 0 0 0 0 0 0 0 0 0" + NL
//                    + "0 1 1 1 0 1 1 0 0 0" + NL
//                    + "0 1 1 1 0 1 1 0 0 0" + NL
//                    + "0 1 1 1 0 0 0 0 0 1",
//                "5")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No17136.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}
