package beakjoon.no002시간복잡도;

import beakjoon.no002시간복잡도.No10158;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class No10158Test {

    @ParameterizedTest
    @CsvSource(value = {"6,4,4,1,8,0 1", "6,4,5,3,4,3 1"})
    void answer(int w, int h, int p, int q, int t, String expected) {
        String answer = No10158.answer(w, h, p, q, t);

        assertEquals(expected, answer);
    }
}