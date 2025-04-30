package beakjoon.no16분할정복;

import java.io.*;
import java.util.*;

public class No1074_1 {

    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int result = zOrder(1 << N, r, c);
        System.out.println(result);
    }

    static int zOrder(int size, int x, int y) {
        if (size == 1) {
            return 0;
        }
        int half = size >> 1;
        int blockArea = half * half;

        if (x < half && y < half) {
            return zOrder(half, x, y);
        } else if (x < half) {
            return blockArea
                    + zOrder(half, x, y - half);
        } else if (y < half) {
            return 2 * blockArea
                    + zOrder(half, x - half, y);
        } else {
            return 3 * blockArea
                    + zOrder(half, x - half, y - half);
        }
    }
}
