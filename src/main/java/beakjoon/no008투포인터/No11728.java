package beakjoon.no008투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        int[] arr1 = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        int[] answer = new int[arr1.length  + arr2.length];

        while (i < arr1.length || j < arr2.length) {
            if (i >= arr1.length) {
                answer[i + j] = arr2[j];
                j++;
                continue;
            }
            if (j >= arr2.length) {
                answer[i + j] = arr1[i];
                i++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                answer[i + j] = arr1[i];
                i++;
                continue;
            }
            answer[i + j] = arr2[j];
            j++;
        }

        for (int a : answer) {
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();
    }
}
