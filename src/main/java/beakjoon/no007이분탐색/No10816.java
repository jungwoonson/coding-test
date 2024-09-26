package beakjoon.no007이분탐색;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No10816 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        int m = sc.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
        }

        for (int i = 0; i < arrM.length; i++) {
            bw.write(counts.getOrDefault(arrM[i],0) + " ");
        }

        bw.flush();
        bw.close();
    }
}
