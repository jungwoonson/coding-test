package beakjoon;

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

class No2817Test {

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
                Arguments.of("235217" + NL + "3" + NL + "A 107382" + NL + "C 18059" + NL + "B 43265",
                        "A 9" + NL + "B 4" + NL + "C 1"),
                Arguments.of("245143" + NL + "4" + NL + "F 14845" + NL + "A 104516" + NL + "B 52652" + NL + "C 14161",
                        "A 8" + NL + "B 4" + NL + "C 1" + NL + "F 1"),
                Arguments.of("206278" + NL + "5" + NL + "D 44687" + NL + "A 68188" + NL + "C 7008" + NL + "B 48377" + NL + "G 9665",
                        "A 6" + NL + "B 4" + NL + "D 4")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No2817.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}