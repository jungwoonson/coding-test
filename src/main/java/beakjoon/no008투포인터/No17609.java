package beakjoon.no008투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            bw.write(checkString(br.readLine()) + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static int checkString(String word) {
        int start = 0;
        int end = word.length() - 1;
        String[] wordArr = word.split("");
        while (start <= end) {
            if (wordArr[start].equals(wordArr[end])) {
                start++;
                end--;
                continue;
            }
            if (wordArr[start + 1].equals(wordArr[end]) || wordArr[start].equals(wordArr[end - 1])) {
                if (isPalindrome(wordArr, start + 1, end) || isPalindrome(wordArr, start, end - 1)) {
                    return 1;
                }
            }
            return 2;
        }
        return 0;
    }

    private static boolean isPalindrome(String[] wordArr, int start, int end) {
        while (start <= end) {
            if (wordArr[start].equals(wordArr[end])) {
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
}
