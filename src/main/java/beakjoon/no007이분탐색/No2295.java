package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;

public class No2295 {

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

        int[] sum = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[index] = U[i] + U[j];
                index++;
            }
        }

        Arrays.sort(sum);
        
        for (int i = U.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < U.length; j++) {
                int number = U[i] - U[j];
                if (isExist(sum, number)) {
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

    static boolean isExist(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) {
                l = m + 1;
                continue;
            }
            if (arr[m] > x) {
                r = m - 1;
                continue;
            }
            return true;
        }
        return false;
    }
}
