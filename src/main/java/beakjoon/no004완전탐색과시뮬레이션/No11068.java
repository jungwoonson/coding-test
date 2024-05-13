package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No11068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(br.readLine());
            boolean flag = true;
            for (int j = 2; j <= 64 ; j++) {
                String conversionNum = conversion(number, j);
                if (isPalindrome(conversionNum)) {
                    bw.write("1" + System.lineSeparator());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                bw.write("0" + System.lineSeparator());
            }
        }

        bw.flush();
        bw.close();
    }

    public static String conversion(final int number, final int b) {
        int value = number;
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            result.append((char) ((value % b) + '0'));
            value = value / b;
        }
        return result.toString();
    }

    public static boolean isPalindrome(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != value.charAt(value.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

