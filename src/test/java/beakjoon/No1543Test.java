package beakjoon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class No1543Test {

    @ParameterizedTest
    @CsvSource(value = {"ababababa,aba,2", "a a a a a,a a,2", "ababababa,ababa,1", "aaaaaaa,aa,3"})
    void answer(String document, String value, int expected) {
        No1543 no1543 = new No1543();

        int answer = no1543.answer(document, value);

        assertEquals(expected, answer);
    }
}