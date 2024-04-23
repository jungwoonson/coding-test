package beakjoon;

import java.io.*;

public class No3273 {

    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String[] numberInputs = br.readLine().split(" ");
        int[] numbers = new int[numberInputs.length];
        for (int i = 0; i < numberInputs.length; i++) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }
        int x = Integer.parseInt(br.readLine());

        int[] counts = new int[2000001];
        for (int i = 0; i < numbers.length; i++) {
            counts[numbers[i]]++;
        }

        int answer = 0;
        int half = (x % 2 == 0) ? (x / 2) : (x / 2 + 1);
        for (int i = 1; i < half; i++) {
            if (counts[i] > 0 && counts[x - i] > 0) {
                answer++;
            }
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
    }
}
