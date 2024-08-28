package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;
import java.util.Arrays;

public class No2840_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] wheel = new String[n];
        Arrays.fill(wheel,"?");

        int index = n - 1;

        for (int i = 0; i < k; i++) {
            String[] turnWheel = br.readLine().split(" ");
            int turnCount = Integer.parseInt(turnWheel[0]);
            String resultWheel = turnWheel[1];

            index = (index - turnCount);
            if (index < 0) {
                if (index % n == 0) {
                    index = 0;
                } else {
                    index = n + (index % n);
                }
            }

            if (!wheel[index].equals("?") && !wheel[index].equals(resultWheel)) {
                bw.write("!" + System.lineSeparator());
                bw.flush();
                bw.close();
                return;
            }

            wheel[index] = resultWheel;

            if (duplicate(index, wheel)) {
                bw.write("!" + System.lineSeparator());
                bw.flush();
                bw.close();
                return;
            }
        }

        for (int i = 0 ; i < n; i++) {
            bw.write(wheel[index]);
            index++;
            index = index % n;
        }

        bw.flush();
        bw.close();
    }

    public static boolean duplicate(int index, String[] wheel) {
        int count = 0;
        for (int i = 0; i < wheel.length; i++) {
            if (wheel[index].equals(wheel[i])) {
                count++;
            }
        }
        return count > 1;
    }
}
