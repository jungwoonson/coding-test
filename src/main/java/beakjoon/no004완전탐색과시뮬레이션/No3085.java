package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No3085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int length = Integer.parseInt(br.readLine());
        final char[][] board = new char[length][length];
        for (int i = 0; i < length; i++) {
            String line = br.readLine();
            for (int j = 0; j < length; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char[][] vChangedBoard = verticalChange(board, i, j);
                max = vMax(vChangedBoard, max);
                max = hMax(vChangedBoard, max);

                char[][] hChangedBoard = horizontalChange(board, i, j);
                max = vMax(hChangedBoard, max);
                max = hMax(hChangedBoard, max);
            }
            if (max >= length) {
                break;
            }
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
    }

    public static char[][] verticalChange(char[][] board, int i, int j) {
        if (i + 1 >= board.length) {
            return board;
        }
        char[][] newBoard = copy(board);
        char temp;
        temp = newBoard[i][j];
        newBoard[i][j] = newBoard[i + 1][j];
        newBoard[i + 1][j] = temp;
        return newBoard;
    }

    public static char[][] horizontalChange(char[][] board, int i, int j) {
        if (j + 1 >= board.length) {
            return board;
        }
        char[][] newBoard = copy(board);
        char temp;
        temp = newBoard[i][j];
        newBoard[i][j] = newBoard[i][j + 1];
        newBoard[i][j + 1] = temp;
        return newBoard;
    }

    public static int vMax(char[][] board, int max) {
        char tempCandy = ' ';
        for (int col = 0; col < board.length; col++) {
            int count = 0;
            for (int row = 0; row < board.length; row++) {
                char candy = board[row][col];
                if (tempCandy != candy) {
                    tempCandy = board[row][col];
                    count = 1;
                    continue;
                }
                count++;
                if (count > max) {
                    max = count;
                }
                if (max >= board.length) {
                    return max;
                }
            }
        }
        return max;
    }

    public static int hMax(char[][] board, int max) {
        char tempCandy = ' ';
        for (int row = 0; row < board.length; row++) {
            int count = 0;
            for (int col = 0; col < board.length; col++) {
                char candy = board[row][col];
                if (tempCandy != candy) {
                    tempCandy = board[row][col];
                    count = 1;
                    continue;
                }
                count++;
                if (count > max) {
                    max = count;
                }
                if (max >= board.length) {
                    return max;
                }
            }
        }
        return max;
    }

    public static char[][] copy(char[][] board) {
        char[][] newBoard = new char[board.length][board.length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                newBoard[row][col] = board[row][col];
            }
        }
        return newBoard;
    }
}
