package beakjoon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class No1919Test {

    @ParameterizedTest
    @CsvSource(value = {"occurs,succor,0", "dared,bread,2", "aabbcc,xxyybb,8"})
    void answer(String a, String b, int expected) {

        No1919 no1919 = new No1919();
        int answer = no1919.answer(a, b);

        assertEquals(expected, answer);
    }
}