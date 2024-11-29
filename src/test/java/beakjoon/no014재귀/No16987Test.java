package beakjoon.no014재귀;

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

class No16987Test {

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
                Arguments.of("3" + NL +
                                "8 5" + NL +
                                "1 100" + NL +
                                "3 5",
                        "3"),
                Arguments.of("3" + NL +
                                "1 100" + NL +
                                "8 5" + NL +
                                "3 5",
                        "2"),
                Arguments.of("1" + NL +
                                "123 45",
                        "0"),
                Arguments.of("8" + NL +
                                "222 117" + NL +
                                "176 92" + NL +
                                "287 6" + NL +
                                "284 81" + NL +
                                "221 96" + NL +
                                "263 96" + NL +
                                "188 40" + NL +
                                "225 1",
                        "4"),
                Arguments.of("6" + NL +
                                "65 281" + NL +
                                "272 145" + NL +
                                "233 175" + NL +
                                "229 12" + NL +
                                "99 88" + NL +
                                "142 159",
                        "6"),
                Arguments.of("8" + NL +
                                "161 36" + NL +
                                "248 93" + NL +
                                "233 13" + NL +
                                "241 122" + NL +
                                "285 91" + NL +
                                "260 25" + NL +
                                "221 14" + NL +
                                "233 42",
                        "3"),
                Arguments.of("3" + NL +
                                "213 295" + NL +
                                "153 24" + NL +
                                "15 233",
                        "3"),
                Arguments.of("8" + NL +
                                "44 11" + NL +
                                "116 73" + NL +
                                "121 54" + NL +
                                "49 232" + NL +
                                "69 136" + NL +
                                "159 242" + NL +
                                "109 172" + NL +
                                "28 31",
                        "8"),
                Arguments.of("6" + NL +
                                "100 1" + NL +
                                "100 1" + NL +
                                "100 1" + NL +
                                "100 1" + NL +
                                "100 1" + NL +
                                "100 1",
                        "0"),
                Arguments.of("1" + NL +
                                "1 1",
                        "0"),
                Arguments.of("1" + NL +
                                "1 1",
                        "0"),
                Arguments.of("2" + NL +
                                "1 1" + NL +
                                "2 1",
                        "1")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No16987_1.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}
