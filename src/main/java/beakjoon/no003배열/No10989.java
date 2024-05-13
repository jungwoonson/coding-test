package beakjoon.no003배열;

import java.io.*;

public class No10989 {

    public static int[] answer(int[] numbers) {
        int[] counts = new int[10001];
        for (int i = 0; i < numbers.length; i++) {
            counts[numbers[i]]++;
        }

        int index = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    numbers[index] = i;
                    index++;
                }
            }
        }

        return numbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];
        for (int i = 0; i < length; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
