package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;

public class No2110 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]); // 2 ≤ N ≤ 200,000
        int c = Integer.parseInt(line[1]); // 2 ≤ C ≤ N

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int start = 1;
        int end = 1_000_000_000;
        int answer = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (isPossible(houses, c, middle)) {
                answer = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        bw.write(answer + System.lineSeparator());
        bw.flush();
        bw.close();
    }

    private static boolean isPossible(int[] houses, int c, int distance) {
        int count = 1;
        int nowIndex = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - nowIndex >= distance) {
                nowIndex = houses[i];
                count++;
            }
            if (count >= c) {
                return true;
            }
        }

        return false;
    }
}
