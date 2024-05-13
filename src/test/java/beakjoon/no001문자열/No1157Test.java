package beakjoon.no001문자열;

import beakjoon.no001문자열.No1157;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class No1157Test {

    @ParameterizedTest
    @CsvSource(value = {"Mississipi,?", "zZa,Z", "z,Z", "baaa,A"})
    void answer(String value, char expected) {
        No1157 no1157 = new No1157();

        char answer = no1157.answer(value);

        assertEquals(expected, answer);
    }
}