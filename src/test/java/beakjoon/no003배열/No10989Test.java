package beakjoon.no003배열;

import beakjoon.no003배열.No10989;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class No10989Test {
    public static Stream<Arguments> data() {
        int[] arr = new int[10000000];
        int number = 10000;
        for(int i = 0; i < arr.length; i++) {
            if (i > arr.length - number) {
                number--;
                arr[i] = number;
            } else {
                arr[i] = number;
            }
        }
        int[] expected = new int[10000000];
        for(int i = 0; i < 10000; i++) {
            expected[i] = i + 1;
        }
        for(int i = 10000; i < 10000000; i++) {
            expected[i] = 10000;
        }
        return Stream.of(
                Arguments.of(new int[] {5,2,3,1,4,2,3,5,1,7}, new int[] {1,1,2,2,3,3,4,5,5,7}),
                Arguments.of(arr, expected)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void answer(int[] numbers, int[] expected) {
        int[] answer = No10989.answer(numbers);
        assertArrayEquals(expected, answer);
    }
}