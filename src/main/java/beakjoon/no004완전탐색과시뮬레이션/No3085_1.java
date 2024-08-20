package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No3085_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] candies = new char[n][n];
        for (int i = 0; i < candies.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < candies[i].length; j++) {
                candies[i][j] = line.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            for (int j = 0; j < candies[i].length; j++) {
                if (j + 1 < candies[i].length) {
                    swapLeftRight(candies, i, j);
                    max = maxVertical(candies, max);
                    max = maxHorizontal(candies, max);
                    swapLeftRight(candies, i, j);
                }

                if (i + 1 < candies[i].length) {
                    swapUpDown(candies, i, j);
                    max = maxVertical(candies, max);
                    max = maxHorizontal(candies, max);
                    swapUpDown(candies, i, j);
                }
            }
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
    }

    public static int maxVertical(char[][] candies, int oldMax) {
        int nowMax = 0;

        for (int i = 0; i < candies.length; i++) {
            int count = 1;
            for (int j = 1; j < candies.length; j++) {
                if (candies[i][j - 1] == candies[i][j]) {
                    count++;
                } else {
                    nowMax = Math.max(nowMax, count);
                    count = 1;
                }
            }

            if (nowMax < count) {
                nowMax = count;
            }
        }
        return  Math.max(nowMax, oldMax);
    }

    public static int maxHorizontal(char[][] candies,int oldMax) {
        int nowMax = 0;

        for (int j = 0; j < candies.length; j++) {
            int count = 1;
            for (int i = 1; i < candies.length; i++) {
                if (candies[i - 1][j] == candies[i][j]) {
                    count++;
                } else {
                    nowMax = Math.max(nowMax, count);
                    count = 1;
                }
            }

            if (nowMax < count) {
                nowMax = count;
            }
        }

        return Math.max(nowMax, oldMax);
    }

    public static void swapLeftRight(char[][] candies, int i, int j) {
        char temp = candies[i][j];
        candies[i][j] = candies[i][j + 1];
        candies[i][j + 1] = temp;
    }

    public static void swapUpDown(char[][] candies, int i, int j) {
        char temp = candies[i][j];
        candies[i][j] = candies[i + 1][j];
        candies[i + 1][j] = temp;
    }
}
