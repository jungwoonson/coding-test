package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No10250_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] inputData = br.readLine().split(" ");

            int h = Integer.parseInt(inputData[0]);
            int w = Integer.parseInt(inputData[1]);
            int n = Integer.parseInt(inputData[2]);

            bw.write(findRoom(h, w, n) + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static int findRoom(int h, int w, int n) {
        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                count++;
                if (count == n) {
                    return ((j + 1) * 100) + (i + 1);
                }
            }
        }
        return 0;
    }
}

