package beakjoon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class No13223Test {

    @ParameterizedTest
    @CsvSource(value = {"20:00:00,04:00:00,08:00:00", "12:34:56,14:36:22,02:01:26"})
    void answer(String now, String target, String expected) {
        No13223 no13223 = new No13223();

        String answer = no13223.answer(now, target);

        assertEquals(expected, answer);
    }
}