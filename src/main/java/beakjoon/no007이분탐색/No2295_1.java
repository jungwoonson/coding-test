package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No2295_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 답을 찾을 때 가지 반복문을 돌린다.
        // 숫자 집합 중 가장 큰 수를 내림차순으로 k라고 지정하고 원소 x + y + z로 만들어지는지 확인한다.
        // 만약 k = 18 이라면
        // 자기 자신보다 작은 수를 x로 지정
        // y + z == 18 - x 이어야 정답

        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];

        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        Set<Integer> sumSet = new HashSet<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumSet.add(U[i] + U[j]);
            }
        }

        for (int i = U.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < U.length; j++) {
                int number = U[i] - U[j];
                if (sumSet.contains(number)) {
                    bw.write(U[i] + System.lineSeparator());
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
