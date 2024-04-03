package beakjoon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class No10158Test {

    @ParameterizedTest
    @CsvSource(value = {"6 4,4 1,8,0 1", "6 4,5 3,4,3 1"})
    void answer(String field, String location, String hour, String expected) {
        No10158 no10158 = new No10158();

        String answer = no10158.answer(field, location, hour);

        assertEquals(expected, answer);
    }
}