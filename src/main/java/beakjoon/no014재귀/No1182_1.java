package beakjoon.no014재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No1182_1 {

    public static BufferedWriter bw;
    public static int result = 0;
    public static int s = 0;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        s = Integer.parseInt(first[1]);

        numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        solve(0, 0);

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    public static void solve(int index, int sum) {
        if (index == numbers.length) {
            return;
        }
        if (sum + numbers[index] == s) {
            result++;
        }

        solve(index + 1, sum);
        solve(index + 1, sum + numbers[index]);
    }
}
