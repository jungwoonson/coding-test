package beakjoon.no014재귀;

import java.io.*;
import java.util.Arrays;

public class No14888 {

    public static BufferedWriter bw;
    public static int result = 0;
    public static int max = -Integer.MAX_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] operation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operation = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        function2(1, numbers[0], operation, numbers);

        bw.write(max + System.lineSeparator());
        bw.write(min + "");

        bw.flush();
        bw.close();
    }

    public static void function2(int index, int sum, int[] operation, int[] numbers) {
        if (isOperationEmpty()) {
            if (sum > max) {
                max = sum;
            }
            if (sum < min) {
                min = sum;
            }
            return;
        }

        for (int i = 0; i < operation.length; i++) {
            if (operation[i] <= 0) {
                continue;
            }

            operation[i]--;
            function2(index + 1, calculate(sum, numbers[index], i), operation, numbers);
            operation[i]++;
        }
    }

    public static boolean isOperationEmpty() {
        for (int i = 0; i < operation.length; i++) {
            if (operation[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static int calculate(int num1, int num2 , int operation) {
        if (operation == 0) {
            return num1 + num2;
        } else if (operation == 1) {
            return num1 - num2;
        } else if (operation == 2) {
            return num1 * num2;
        }
        return num1 / num2;
    }
}
