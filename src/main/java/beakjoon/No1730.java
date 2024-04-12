package beakjoon;

import java.io.*;

public class No1730 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        char[][] board = new char[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = '.';
            }
        }

        String commend = br.readLine();

        int p = 0;
        int q = 0;
        for (int i = 0; i < commend.length(); i++) {
            int moveP = moveP(p, commend.charAt(i), length);
            int moveQ = moveQ(q, commend.charAt(i), length);
            if (moveP == p && moveQ == q) {
                continue;
            }
            board[p][q] = shape(board[p][q], commend.charAt(i));
            p = moveP(p, commend.charAt(i), length);
            q = moveQ(q, commend.charAt(i), length);
            board[p][q] = shape(board[p][q], commend.charAt(i));
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                bw.write(board[i][j]);
            }
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static char shape(char nowShape, char command) {
        char result = '.';
        if (command == 'U' || command == 'D') {
            result = '|';
        } else {
            result = '-';
        }

        if (nowShape == '+') {
            return nowShape;
        }
        if (nowShape == '-' && result == '|') {
            return '+';
        }
        if (nowShape == '|' && result == '-') {
            return '+';
        }
        return result;
    }

    public static int moveP(int p, char command, int length) {
        if (command == 'U') {
            if (p - 1 < 0) {
                return 0;
            }
            return --p;
        }
        if (command == 'D') {
            if (p + 1 > length - 1) {
                return p;
            }
            return ++p;
        }
        return p;
    }

    public static int moveQ(int q, char command, int length) {
        if (command == 'L') {
            if (q - 1 < 0) {
                return 0;
            }
            return --q;
        }
        if (command == 'R') {
            if (q + 1 > length - 1) {
                return q;
            }
            return ++q;
        }
        return q;
    }
}
