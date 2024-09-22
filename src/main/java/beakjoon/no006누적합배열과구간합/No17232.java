package beakjoon.no006누적합배열과구간합;

import java.io.*;

public class No17232 {

    private static final char LIFE = '*';
    private static final char DEAD = '.';

    private static int n;
    private static int m;
    private static int k;
    private static int a;
    private static int b;

    private static char[][] board;
    private static int[][] prefixSum;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);
        int t = Integer.parseInt(line1[2]);

        String[] line2 = br.readLine().split(" ");
        k = Integer.parseInt(line2[0]);
        a = Integer.parseInt(line2[1]);
        b = Integer.parseInt(line2[2]);

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int turn = 0; turn < t; turn++) {
            drawPrefixSumBoard();
            move();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(board[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void drawPrefixSumBoard() {
        prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = getPrefix(board, i, j, prefixSum);
            }
        }
    }

    private static int getPrefix(char[][] board, int i, int j, int[][] prefixSum) {
        return (board[i - 1][j - 1] == LIFE ? 1 : 0) + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
    }

    private static void move() {
        char[][] tempBoard = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nearCount = getNearCount(i, j);
                if(board[i][j] == LIFE && nearCount >= a && nearCount <= b) {
                    tempBoard[i][j] = LIFE;
                } else if (board[i][j] == DEAD && nearCount > a && nearCount <= b) {
                    tempBoard[i][j] = LIFE;
                } else {
                    tempBoard[i][j] = DEAD;
                }
            }
        }

        board = tempBoard;
    }

    private static int getNearCount(int x, int y) {
        int endX = Math.min(x + k + 1, n);
        int endY = Math.min(y + k + 1, m);
        int startX = Math.max(x - k + 1, 1);
        int startY = Math.max(y - k + 1, 1);

        int count = prefixSum[endX][endY] - prefixSum[startX - 1][endY] - prefixSum[endX][startY - 1] + prefixSum[startX - 1][startY - 1];
        if (board[x][y] == LIFE) {
            count--;
        }

        return count;
    }
}
