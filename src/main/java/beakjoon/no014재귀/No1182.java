package beakjoon.no014재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No1182 {

    public static BufferedWriter bw;
    public static int result = 0;
    public static int s = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        s = Integer.parseInt(first[1]);

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int depth = 0; depth < numbers.length; depth++) {
            function2(depth, numbers[depth], numbers);
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    public static void function2 (int index, int sum, int[] numbers) {
        if (s == sum) {
            result++;
        }

        for (int i = index + 1; i < numbers.length; i++) {
            function2(i, sum + numbers[i], numbers);
        }
    }
}
