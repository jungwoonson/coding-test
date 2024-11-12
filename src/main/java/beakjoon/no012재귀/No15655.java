package beakjoon.no012재귀;

import java.io.*;
import java.util.Arrays;

public class No15655 {

    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        boolean[] check = new boolean[n];
        int[] output = new int[m];

        function(m, 0, arr, check, output);

        bw.flush();
        bw.close();
    }

    public static void function(int m, int depth, Integer[] arr, boolean[] check, int[] output) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(output[i] + "");
                if (i != m - 1) {
                    bw.write(" ");
                }
            }
            bw.write(System.lineSeparator());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                for (int j = 0; j < i; j++) {
                     check[j] = true;
                }
                check[i] = true;
                output[depth] = arr[i];
                function(m, depth + 1, arr, check, output);
                check[i] = false;
                for (int j = 0; j < i; j++) {
                    check[j] = false;
                }
            }
        }
    }
}
