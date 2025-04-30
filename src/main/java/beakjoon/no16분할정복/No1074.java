package beakjoon.no16분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int r = Integer.parseInt(line.split(" ")[1]);
        int c = Integer.parseInt(line.split(" ")[2]);

        int length = (int) Math.pow(2, n);
        bw.write(recursion(r, c, 0, length, 0, length, n) + "");

        bw.flush();
        bw.close();
    }

    public static int recursion(int r, int c, int rMin, int rMax, int cMin, int cMax, int level) {
        int half = (rMax - rMin) / 2;
        int area = area(r, c, half, rMax, cMax);

        if (level == 1) {
            return area;
        }

        if (area == 0) {
            rMax -= half;
            cMax -= half;
        }
        if (area == 1) {
            rMax -= half;
            cMin += half;
        }
        if (area == 2) {
            rMin += half;
            cMax -= half;
        }
        if (area == 3) {
            rMin += half;
            cMin += half;
        }

        return ((int) (Math.pow(2, level - 1) * Math.pow(2, level - 1))) * area
                + recursion(r, c, rMin, rMax, cMin, cMax, level - 1);
    }

    public static int area(int r, int c, int half, int rMax, int cMax) {
        if (r < rMax - half && c < cMax - half) {
            return 0;
        }
        if (r < rMax - half) {
            return 1;
        }
        if (c < cMax - half) {
            return 2;
        }
        return 3;
    }
}