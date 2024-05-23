package beakjoon.no006누적합배열과구간합;

import java.io.*;
import java.util.Arrays;

public class No16713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int q = Integer.parseInt(line1[1]);

        Integer[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        int[] prefixSum = prefixSum(array);

        int result = 0;
        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]) - 1;

            int xor;
            if (start != 0) {
                xor = prefixSum[start - 1] ^ prefixSum[end];
            } else {
                xor = prefixSum[end];
            }
            result = result ^ xor;
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    public static int[] prefixSum(Integer[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                result[i] = array[i];
                continue;
            }
            result[i] = result[i - 1] ^ array[i];
        }
        return result;
    }
}
