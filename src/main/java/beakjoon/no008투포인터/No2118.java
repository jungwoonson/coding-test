package beakjoon.no008투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2118 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] towers = new int[n];
        int[] prefixSum = new int[n];
        int sum = 0;

        for (int i = 0; i < towers.length; i++) {
            int distance = Integer.parseInt(br.readLine());
            towers[i] = distance;
            sum += distance;
            if (i > 0) {
                prefixSum[i] = prefixSum[i - 1] + towers[i];
            } else {
                prefixSum[i] = towers[i];
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int clockDistance = prefixSum[j] - prefixSum[i];
                int reversClockDistance = sum - clockDistance;
                int distance = Math.min(clockDistance, reversClockDistance);
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }

        bw.write(maxDistance + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
