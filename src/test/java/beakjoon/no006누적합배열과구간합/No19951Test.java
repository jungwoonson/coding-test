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

public class No19951Test {

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
                Arguments.of("10 3" + NL +
                        "1 2 3 4 5 -1 -2 -3 -4 -5" + NL +
                        "1 5 -3" + NL +
                        "6 10 5" + NL +
                        "2 7 2",
                        "-2 1 2 3 4 6 5 2 1 0")
        );
    }

    //   01   02   03   04   05   06   07   08   09   10
    // |  1 |  2 |  3 |  4 |  5 | -1 | -2 | -3 | -4 | -5 |

    // | -3 | -3 | -3 | -3 | -3 |  0 |  0 |  0 |  0 |  0 |
    // |  0 |  0 |  0 |  0 |  0 |  5 |  5 |  5 |  5 |  5 |
    // |  0 |  2 |  2 |  2 |  2 |  2 |  2 |  0 |  0 |  0 |

    // | -3 |  2 |  0 |  0 |  0 |  8 |  0 | -2 |  0 |  0 |

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No19951.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}
