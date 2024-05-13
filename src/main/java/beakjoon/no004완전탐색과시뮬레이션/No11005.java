package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = br.readLine().split(" ");
        int number = Integer.parseInt(data[0]);
        final int b = Integer.parseInt(data[1]);
        StringBuilder answer = new StringBuilder();

        do {
            answer.insert(0, conversion(number % b));
            number = number / b;
        } while (number / b != 0);

        if (number != 0) {
            answer.insert(0, conversion(number));
        }

        bw.write(answer.toString());

        bw.flush();
        bw.close();
    }

    public static String conversion(int number) {
        if (number < 10) {
            return String.valueOf((char) ('0' + number));
        }
        return String.valueOf((char) (number - 10 + 'A'));
    }
}
