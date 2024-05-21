package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] stringNumbers = br.readLine().split(" ");

        int[][] numbers = new int[n][2];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i][0] = Integer.parseInt(stringNumbers[i]);
            numbers[i][1] = i;
        }

        Arrays.sort(numbers, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[] result = new int[n];
        int index = 0;
        result[numbers[0][1]] = index;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i][0] != numbers[i - 1][0]) {
                index++;
            }
            result[numbers[i][1]] = index;
        }

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
