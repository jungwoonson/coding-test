package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;

public class No2805_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        long n = Integer.parseInt(line[0]);
        long m = Integer.parseInt(line[1]);
        String[] line2 = br.readLine().split(" ");

        Integer[] trees = Arrays.stream(line2)
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        int index = getMid(trees, m);
        long start = trees[index];
        long end = trees[trees.length - 1];

        long result = 0;
        for (long i = start; i <= end; i++) {
            if (calcCutTreeSum(trees, index, i) >= m) {
                result = i;
            } else {
                break;
            }
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    public static int getMid(Integer[] trees, long m) {
        int start = 0;
        int end = trees.length - 1;
        int result = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (calcCutTreeSum(trees, mid) >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static long calcCutTreeSum(Integer[] trees, int start, long m) {
        long result = 0;
        for (int i = start; i <= trees.length - 1; i++) {
            result += cut(trees[i], m);
        }
        return result;
    }

    public static long calcCutTreeSum(Integer[] trees, int start) {
        long result = 0;
        for (int i = start; i <= trees.length - 1; i++) {
            result += cut(trees[i], trees[start]);
        }
        return result;
    }

    public static long cut(long treeHigh, long h) {
        long result = treeHigh - h;
        if (result <= 0) {
            result = 0;
        }
        return result;
    }
}
