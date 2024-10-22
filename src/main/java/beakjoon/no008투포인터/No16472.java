package beakjoon.no008투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No16472 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int[] arrCount = new int[26];

        int start = 0;
        int end = 0;
        int maxLength = 0;

        while (end < arr.length) {
            arrCount[index(arr[end])]++;

            while (countChar(arrCount) > n) {
                arrCount[index(arr[start])]--;
                start++;
            }

            if (maxLength < end - start + 1) {
                maxLength = end - start + 1;
            }

            end++;
        }

        bw.write(maxLength + System.lineSeparator());

        bw.flush();
        bw.close();
    }

    public static int countChar(int[] arrCount) {
        int result = 0;
        for (int count : arrCount) {
            if (count > 0) {
                result++;
            }
        }
        return result;
    }

    public static int index(String value) {
        return value.charAt(0) - 'a';
    }
}
