package beakjoon.no001문자열;

import beakjoon.no001문자열.No13223;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class No13223Test {

    @ParameterizedTest
    @CsvSource(value = {"20:00:00,04:00:00,08:00:00", "12:34:56,14:36:22,02:01:26", "14:59:56,14:36:57,23:37:01",
            "00:59:51,00:00:50,23:00:59", "01:01:51,01:02:50,00:00:59", "00:00:00,00:00:00,24:00:00"})
    void answer(String now, String target, String expected) {
        No13223 no13223 = new No13223();

        String answer = no13223.answer(now, target);

        assertEquals(expected, answer);
    }
}