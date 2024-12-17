package beakjoon.no15퇴각검색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No17136 {

    public static int min;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] papers = {0, 5, 5, 5, 5, 5};
        min = Integer.MAX_VALUE;
        cnt = 0;

        int[][] board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        recursion(board, papers, 0, 0, 0);
        bw.write((min == Integer.MAX_VALUE ? -1 : min) + "");

        bw.flush();
        bw.close();
    }

    public static void recursion(int[][] board, int[] papers, int v, int h, int count) {
        if (count >= min) {
            return;
        }

        if (v == 10) {
            min = Math.min(count, min);
            return;
        }

        if (h == 10) {
            recursion(board, papers, v + 1, 0, count);
            return;
        }

        if (board[v][h] == 0) {
            recursion(board, papers, v, h + 1, count);
            return;
        }

        for (int paperSize = 5; paperSize >= 1; paperSize--) {
            if (papers[paperSize] > 0 && valid(board, paperSize, v, h)) {
                attach(board, paperSize, v, h, 0);
                papers[paperSize]--;
                recursion(board, papers, v, h + 1, count + 1);
                attach(board, paperSize, v, h, 1);
                papers[paperSize]++;
            }
        }
    }

    public static boolean valid(int[][] board, int paperSize, int v, int h) {
        if (v + (paperSize - 1) >= 10) {
            return false;
        }
        if (h + (paperSize - 1) >= 10) {
            return false;
        }

        for (int i = v; i < v + paperSize; i++) {
            for (int j = h; j < h + paperSize; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void attach(int[][] board, int paperSize, int v, int h, int value) {
        for (int i = v; i < v + paperSize; i++) {
            for (int j = h; j < h + paperSize; j++) {
                board[i][j] = value;
            }
        }
    }
}