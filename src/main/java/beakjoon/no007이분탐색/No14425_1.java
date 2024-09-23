package beakjoon.no007이분탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No14425_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n 만큼 반복문을 돌린다
        // 반복문 안에서 m 문자열에 집합 S의 원소 s가 존재하는지 확인한다.
        // s의 존재여부를 파악 할 때 이분탐색을 활용한다.

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        List<String> set = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String check = br.readLine();
            if(set.contains(check)) {
                count++;
            }
        }

        bw.write(count + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
