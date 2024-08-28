package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;
import java.util.Arrays;

public class No1730_1 {

    private static final String EMPTY = ".";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String CROSS = "+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] panel = new String[N][N];
        String[] command = br.readLine().split("");
        int x = 0;
        int y = 0;

        for (int i = 0; i < panel.length; i++) {
            Arrays.fill(panel[i], EMPTY);
        }

        for (int i = 0; i < command.length; i++) {

            if (command[i].equals("U") && y > 0) {
                panel[y][x] = paintPanel(VERTICAL, panel[y][x]);
                y -= 1;
                panel[y][x] = paintPanel(VERTICAL, panel[y][x]);
            } else if (command[i].equals("D") && y < N - 1) {
                panel[y][x] = paintPanel(VERTICAL, panel[y][x]);
                y += 1;
                panel[y][x] = paintPanel(VERTICAL, panel[y][x]);
            } else if (command[i].equals("L") && x > 0) {
                panel[y][x] = paintPanel(HORIZONTAL, panel[y][x]);
                x -= 1;
                panel[y][x] = paintPanel(HORIZONTAL, panel[y][x]);
            } else if (command[i].equals("R") && x < N - 1) {
                panel[y][x] = paintPanel(HORIZONTAL, panel[y][x]);
                x += 1;
                panel[y][x] = paintPanel(HORIZONTAL, panel[y][x]);
            }
        }

        for (int i = 0; i < panel.length; i++) {
            for (int j = 0; j < panel.length; j++) {
                bw.write(panel[i][j]);
            }
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static String paintPanel(String paint, String nowPaint) {

        if (nowPaint.equals(VERTICAL) && paint.equals(HORIZONTAL)) {
            return CROSS;
        } else if (nowPaint.equals(HORIZONTAL) && paint.equals(VERTICAL)) {
            return CROSS;
        } else if (nowPaint.equals(CROSS)) {
            return CROSS;
        }

        return paint;
    }
}
