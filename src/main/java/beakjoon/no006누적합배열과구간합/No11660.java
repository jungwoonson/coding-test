package beakjoon.no006누적합배열과구간합;

import java.io.*;

public class No11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int[][] array = new int[n + 1][n + 1];
        for (int i = 1; i < array.length; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j < array.length; j++) {
                array[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        int[][] prefixSum = rowPrefixSum(array);

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            int result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            bw.write(result + System.lineSeparator());
        }


        bw.flush();
        bw.close();
    }

    private static int[][] rowPrefixSum(int[][] array) {
        int[][] result = new int[array.length][array.length];
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result.length; j++) {
                result[i][j] = -result[i - 1][j - 1] + result[i - 1][j] + result[i][j - 1] + array[i][j];
            }
        }
        return result;
    }
}
