package beakjoon.no008투포인터;

import java.io.*;
import java.util.Arrays;

public class No1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int s = Integer.parseInt(inputs[1]);

        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = Integer.MAX_VALUE;
        int currentSum = numbers[0];
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            while (currentSum < s && endIndex < n - 1) {
                currentSum += numbers[++endIndex];
            }

            if(currentSum >= s && answer > endIndex - i + 1) {
                answer = endIndex - i + 1;
            }

            currentSum -= numbers[i];
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        bw.write(answer + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
