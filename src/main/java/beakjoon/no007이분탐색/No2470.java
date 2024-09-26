package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class No2470 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int N =Integer.parseInt( br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);;
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int san = 0;
        int al = 0;

        int first = 0;
        int end = arr.length - 1;

        while (first < end) {
            int sum = arr[first] + arr[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                san = arr[first];
                al = arr[end];
            }

            if (sum >= 0) {
                end--;
            } else {
                first++;
            }
        }

        bw.write(san + " " + al);

        bw.flush();
        bw.close();
    }
}
