package beakjoon.no008투포인터;

import java.io.*;
import java.util.Arrays;

public class No2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        Integer n = Integer.parseInt(inputs[0]);
        Integer m = Integer.parseInt(inputs[1]);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int answer = Integer.MAX_VALUE;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            while (numbers[endIndex] - numbers[i] < m && endIndex < n - 1) {
                endIndex++;
            }

            int sum = numbers[endIndex] - numbers[i];

            if (sum >= m && answer > sum) {
                answer = sum;
            }
        }

        bw.write(answer + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
