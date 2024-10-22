package beakjoon.no008투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No15831 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int maxB = Integer.parseInt(input[1]);
        int minW = Integer.parseInt(input[2]);

        String[] road = br.readLine().split("");

        int start = -1;
        int end = -1;

        int countBlack = 0;
        int countWhite = 0;
        int maxLength = 0;

        while (start < n - 1 && end < n) {
            if (countBlack <= maxB && end < n - 1) {
                end++;
                if (road[end].equals("W")) {
                    countWhite++;
                } else {
                    countBlack++;
                }
            } else {
                start++;
                if (road[start].equals("W")) {
                    countWhite--;
                } else {
                    countBlack--;
                }
            }

            if (countBlack <= maxB && countWhite >= minW && maxLength < end - start) {
                maxLength = end - start;
            }
        }

        bw.write(maxLength + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
