package beakjoon.no008투포인터;

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

class No12891Test {

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
//                Arguments.of("9 8" + NL +
//                                "CCTGGATTG" + NL +
//                                "2 0 1 1",
//                        "0"),
//                Arguments.of("4 2" + NL +
//                                "GATA" + NL +
//                                "1 0 0 1",
//                        "2"),
//                Arguments.of("4 4" + NL +
//                                "CCTG" + NL +
//                                "0 0 1 1",
//                        "1"),
//                Arguments.of("1 1" + NL +
//                                "T" + NL +
//                                "0 0 0 1",
//                        "1"),
//                Arguments.of("8 1" + NL +
//                                "TTTTTTTT" + NL +
//                                "0 0 0 1",
//                        "8"),
//                Arguments.of("8 2" + NL +
//                                "TTTTTTTT" + NL +
//                                "0 0 0 2",
//                        "7"),
                Arguments.of("8 3" + NL +
                                "TTTTTTTT" + NL +
                                "0 0 0 2",
                        "6")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No12891.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}