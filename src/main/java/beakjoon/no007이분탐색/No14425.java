package beakjoon.no007이분탐색;

import java.io.*;
import java.util.Arrays;

public class No14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n 만큼 반복문을 돌린다
        // 반복문 안에서 m 문자열에 집합 S의 원소 s가 존재하는지 확인한다.
        // s의 존재여부를 파악 할 때 이분탐색을 활용한다.

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }
        Arrays.sort(s);

        String[] t = new String[m];
        for (int i = 0; i < m; i++) {
            t[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < t.length; i++) {
            if (isExist(s, t[i])) {
                count++;
            }
        }
        
        bw.write(count + System.lineSeparator());

        bw.flush();
        bw.close();
    }

    public static boolean isExist(String[] target, String source) {
        int l = 0;
        int r = target.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target[m].compareTo(source) < 0) {
                l = m + 1;
                continue;
            }
            if (target[m].compareTo(source) > 0) {
                r = m - 1;
                continue;
            }
            return true;
        }
        return false;
    }
}
