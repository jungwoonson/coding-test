package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No1931_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] meetingArr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            meetingArr[i][0] = Integer.parseInt(input[0]);//시작
            meetingArr[i][1] = Integer.parseInt(input[1]);//종료
        }

        Arrays.sort(meetingArr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < meetingArr.length; i++) {
            if (meetingArr[i][0] >= endTime) {
                count++;
                endTime = meetingArr[i][1];
            }
        }

        bw.write(count + "");

        bw.flush();
        bw.close();
    }
}

// 0-1-2-3-4-5-6-7-8-9-0-1-2-3-4-5-6-
// |-1-----4-|-|-|-|-|-|-|-|-|-|-|-|-
// |-|-|-3---5-|-|-|-|-|-|-|-|-|-|-|-
// 0-----------6-|-|-|-|-|-|-|-|-|-|-
// |-|-|-3---------8-|-|-|-|-|-|-|-|-
// |-|-|-!-4-5-|-|-|-|-|-|-|-|-|-|-|-
// |-|-|-!-!-5-|-|-|-|-|-|-|-|-|-|-|-
// |-|-|-!-!-5---7-|-|-|-|-|-|-|-|-|-
// |-|-|-3-------7-|-|-|-|-|-|-|-|-|-
// |-|-|-|-|-5-------9-|-|-|-|-|-|-|-
// |-|-|-|-|-|-6------10-|-|-|-|-|-|-
// |-|-|-|-|-|-|-|-8----11-|-|-|-|-|-
// |-|-|-|-|-|-|-|-8------12-|-|-|-|-
// |-|-2--------------------13-|-|-|-
// |-|-|-|-|-|-|-|-|-|-|-|12--14-|-|-
