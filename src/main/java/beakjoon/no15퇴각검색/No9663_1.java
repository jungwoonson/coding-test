package beakjoon.no15퇴각검색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No9663_1 {
    static int N, count = 0;
    static boolean[] col, diag1, diag2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col   = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];
        place(0);
        System.out.print(count);
    }

    static void place(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int c = 0; c < N; c++) {
            int d1 = row + c;
            int d2 = row - c + N - 1;
            if (col[c] || diag1[d1] || diag2[d2]) continue;
            col[c] = diag1[d1] = diag2[d2] = true;
            place(row + 1);
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}
