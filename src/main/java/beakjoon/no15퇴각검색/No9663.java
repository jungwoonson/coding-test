package beakjoon.no15퇴각검색;

import java.io.*;

public class No9663 {

    private static int result = 0;
    private static int[][][] boards;
    private static int n;
    private static final int[][] directions = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, -1}, // 좌
            {0, 1}, // 우
            {-1, -1}, // 좌상
            {-1, 1}, // 우상
            {1, -1}, // 좌하
            {1, 1} // 우하
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        boards = new int[n][n][n];

        recursion(n, 0, 0);
        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    public static void recursion(int n, int level, int y) {
        if (level == n) {
            result++;
            return;
        }

        for (int i = y; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boards[level][i][j] != 1 && isEmptyLine(i, j)) {
                    setTemp(i, j, level);
                    recursion(n, level + 1, i + 1);
                    clearTemp(i, j, level);
                }
            }
        }
    }

    private static boolean isEmptyLine(int i, int j) {
        for (int[][] board : boards) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void setTemp(int i, int j, int level) {
        boards[level][i][j] = 1;
        for (int[] direction : directions) {
            int y = i + direction[0];
            int x = j + direction[1];
            while (y >= 0 && x >= 0 && y < n && x < n) {
                boards[level][y][x] = 1;
                y += direction[0];
                x += direction[1];
            }
        }
    }

    private static void clearTemp(int i, int j, int level) {
        boards[level][i][j] = 0;
        for (int[] direction : directions) {
            int y = i + direction[0];
            int x = j + direction[1];
            while (y >= 0 && x >= 0 && y < n && x < n) {
                boards[level][y][x] = 0;
                y += direction[0];
                x += direction[1];
            }
        }
    }
}
