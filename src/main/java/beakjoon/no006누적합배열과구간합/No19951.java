package beakjoon.no006누적합배열과구간합;

import java.io.*;
import java.util.Arrays;

public class No19951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 일렬 로N칸 길이의 연병장
        // 각 칸마다 흙의 높이가 있다
        // 조교 M 명
        // a~b 칸 까지 k 높이에 맞춰서 흙을 파내거나 덮는다
        // 모두 수행한뒤 각 칸의 높이 구하기

        //   01   02   03   04   05   06   07   08   09   10
        // |  1 |  2 |  3 |  4 |  5 | -1 | -2 | -3 | -4 | -5 |
        // | -3 | -3 | -3 | -3 | -3 |  0 |  0 |  0 |  0 |  0 |
        // |  0 |  0 |  0 |  0 |  0 |  5 |  5 |  5 |  5 |  5 |
        // |  0 |  2 |  2 |  2 |  2 |  2 |  2 |  0 |  0 |  0 |


        // |  1 |  2 |  3 |  4 |  5 | -1 | -2 | -3 | -4 | -5 |
        // | -3 | -1 | -1 | -1 | -1 |  7 |  7 |  5 |  5 |  5 |  0
        // | -2 |  1 |  2 |  3 |  4 |  6 |  5 |  2 |  1 |  0 |
        // 1, 3, 6, 10, 15, 14, 12, 9, 5, 0

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        int[] ground = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] diffSum = new int[N + 2];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int h = Integer.parseInt(input[2]);
            diffSum[a] += h;
            diffSum[b + 1] -= h;
        }

        for (int i = 0; i < N; i++) {
            diffSum[i + 1] = diffSum[i] + diffSum[i + 1];
            ground[i] += diffSum[i + 1];

            bw.write(ground[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
