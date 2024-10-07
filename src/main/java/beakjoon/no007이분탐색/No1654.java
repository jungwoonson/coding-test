package beakjoon.no007이분탐색;

import java.io.*;

public class No1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int k = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[] lines = new int[k];

        long max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if(max < lines[i]) {
                max = lines[i];
            }
        }

        long start = 1;
        long end = max;
        long answer = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long lanCount = 0;

            for (int i = 0; i < k; i++) {
                lanCount += lines[i] / middle;
            }

            if (lanCount >= n) {
                answer = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        bw.write(answer + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
