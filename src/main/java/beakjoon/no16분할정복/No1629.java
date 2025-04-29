package beakjoon.no16분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        long a = Long.parseLong(line.split(" ")[0]);
        long b = Long.parseLong(line.split(" ")[1]);
        long c = Long.parseLong(line.split(" ")[2]);

        bw.write(recursion(a, b, c) + "");

        bw.flush();
        bw.close();
    }

    public static long recursion(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long half = recursion(a, b / 2, c);
        if (b % 2 == 0) {
            return (half * half) % c;
        }
        return half * half % c * a % c;
    }
}