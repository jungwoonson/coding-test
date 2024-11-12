package beakjoon.no012재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No15656 {

    public static BufferedWriter bw;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        int[] output = new int[m];

        recursion(0, arr, output);

        bw.flush();
        bw.close();
    }

    public static void recursion(int depth, Integer[] arr, int[] output)
        throws IOException {
        if (depth == m) {
            for (int i = 0; i < output.length; i++) {
                bw.write(output[i] + "");
                if (i != output.length - 1) {
                    bw.write(" ");
                }
            }
            bw.write(System.lineSeparator());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            output[depth] = arr[i];
            recursion(depth + 1, arr, output);
        }
    }
}
