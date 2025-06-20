package reetcode.queue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OpenTheLockTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(String[] deadends, String target, int expected) {
        int actual = new OpenTheLock().openLock(deadends, target);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
                Arguments.of(new String[]{"8888"}, "0009", 1),
                Arguments.of(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888",
                        "9888"}, "8888", -1)
        );
    }
}
