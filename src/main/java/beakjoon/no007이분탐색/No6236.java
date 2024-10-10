package beakjoon.no007이분탐색;

import java.io.*;

public class No6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] moneys = new int[n];

        for (int i = 0; i < n; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = n * 10000;
        int answer = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (isPossible(moneys, middle, m)) {
                answer = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        bw.write(answer + System.lineSeparator());

        bw.flush();
        bw.close();
    }

    private static boolean isPossible(int[] amount, int drawAmount, int maxCount) {
        int count = 1;
        int currentAmount = drawAmount;

        for (int i = 0; i < amount.length; i++) {
            if (drawAmount < amount[i]) {
                return false;
            }
            if (currentAmount < amount[i]) {
                if (count == maxCount) {
                    return false;
                }
                count++;
                currentAmount = drawAmount;
            }
            currentAmount -= amount[i];
        }
        return true;
    }
}
