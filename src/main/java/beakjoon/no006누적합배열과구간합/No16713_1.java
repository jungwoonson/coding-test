package beakjoon.no006누적합배열과구간합;

import java.io.*;
import java.util.Arrays;

public class No16713_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int Q = Integer.parseInt(input1[1]);
        int[] arr = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();
        int[] arrSum = new int[arr.length + 1];

        for (int i = 1; i < arrSum.length; i++) {
            if (i == 1) {
                arrSum[i] = arr[i - 1];
                continue;
            }
            arrSum[i] = arrSum[i - 1] ^ arr[i - 1];
        }

        int answer = 0;
        for (int i = 0; i < Q; i++) {
            String[] input3 = br.readLine().split(" ");

            int startIndex = Integer.parseInt(input3[0]);
            int endIndex = Integer.parseInt(input3[1]);

            answer = answer ^ arrSum[endIndex] ^ arrSum[startIndex - 1];
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
    }
}
