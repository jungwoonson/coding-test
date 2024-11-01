package beakjoon.no011스택;

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

class No4949Test {

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
            Arguments.of("So when I die (the [first] I will see in (heaven) is a score list)." + NL
                    + "[ first in ] ( first out )." + NL
                    + "Half Moon tonight (At least it is better than no Moon at all]." + NL
                    + "A rope may form )( a trail in a maze." + NL
                    + "Help( I[m being held prisoner in a fortune cookie factory)]." + NL
                    + "([ (([( [ ] ) ( ) (( ))] )) ])." + NL
                    + " ." + NL
                    + ".",
                "yes" + NL
                    + "yes" + NL
                    + "no" + NL
                    + "no" + NL
                    + "no" + NL
                    + "yes" + NL
                    + "yes")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void main(String data, String expected) throws IOException {
        InOutputUtil.setIn(data);

        No4949.main(new String[0]);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}