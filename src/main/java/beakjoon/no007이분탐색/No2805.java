package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;

public class No2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[] line2 = br.readLine().split(" ");

        Integer[] trees = Arrays.stream(line2)
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        int start = 0;
        int end = trees[trees.length - 1];
        int max = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (Integer tree : trees) {
                if (tree > mid) {
                    sum = sum + tree - mid;
                }
            }

            if (sum >= m) {
                max = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(max + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
