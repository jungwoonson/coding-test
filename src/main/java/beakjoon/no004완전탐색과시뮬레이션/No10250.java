package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;

public class No10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] values = br.readLine().split(" ");
            int h = Integer.parseInt(values[0]);
            int w = Integer.parseInt(values[1]);
            int order = Integer.parseInt(values[2]);

            int floor = order % h == 0 ? h : order % h;
            int room = (order - 1) / h + 1;

            bw.write(String.format("%d%02d", floor, room) + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}

