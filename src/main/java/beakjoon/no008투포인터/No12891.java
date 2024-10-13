package beakjoon.no008투포인터;

import java.io.*;
import java.util.Arrays;

public class No12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int s = Integer.parseInt(input1[0]);
        int p = Integer.parseInt(input1[1]);
        String[] arr = br.readLine().split("");
        int[] conditions = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = 0;
        for (int i = 0; i < p; i++) {
            if (arr[i].equals("A")) {
                conditions[0]--;
            } else if (arr[i].equals("C")) {
                conditions[1]--;
            } else if (arr[i].equals("G")) {
                conditions[2]--;
            } else if (arr[i].equals("T")) {
                conditions[3]--;
            }
        }

        if (conditions[0] <= 0 && conditions[1] <= 0 && conditions[2] <= 0 && conditions[3] <= 0) {
            answer++;
        }

        int start = 0;
        int end =  p;
        while (end < s) {
            if (arr[start].equals("A")) {
                conditions[0]++;
            } else if (arr[start].equals("C")) {
                conditions[1]++;
            } else if (arr[start].equals("G")) {
                conditions[2]++;
            } else if (arr[start].equals("T")) {
                conditions[3]++;
            }

            if (arr[end].equals("A")) {
                conditions[0]--;
            } else if (arr[end].equals("C")) {
                conditions[1]--;
            } else if (arr[end].equals("G")) {
                conditions[2]--;
            } else if (arr[end].equals("T")) {
                conditions[3]--;
            }

            if (conditions[0] <= 0 && conditions[1] <= 0 && conditions[2] <= 0 && conditions[3] <= 0) {
                answer++;
            }

            start++;
            end++;
        }

        bw.write(answer + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
