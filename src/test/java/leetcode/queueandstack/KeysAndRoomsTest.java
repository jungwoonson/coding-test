package leetcode.queueandstack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KeysAndRoomsTest {

    @ParameterizedTest
    @MethodSource("data")
    void test(List<List<Integer>> rooms, boolean expected) {
        boolean actual = new KeysAndRooms().canVisitAllRooms(rooms);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(1),
                                List.of(2),
                                List.of(3),
                                List.of()
                        ),
                        true),
                Arguments.of(
                        List.of(
                                List.of(1, 3),
                                List.of(3, 0, 1),
                                List.of(2),
                                List.of(0)
                        ),
                        false)
        );
    }
}
