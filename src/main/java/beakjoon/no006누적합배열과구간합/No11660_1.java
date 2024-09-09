package beakjoon.no006누적합배열과구간합;

import java.io.*;

public class No11660_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        
        int[][] sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int area = Integer.parseInt(input[j - 1]);
                sum[i][j] = area + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int startX = Integer.parseInt(input2[0]);
            int startY = Integer.parseInt(input2[1]);
            int endX = Integer.parseInt(input2[2]);
            int endY = Integer.parseInt(input2[3]);

            int result = sum[endX][endY] - sum[startX - 1][endY] - sum[endX][startY - 1] + sum[startX - 1][startY - 1];
            bw.write(result + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}

// |  0 |  0 |  0 |  0 |  0 | , 0
// |  0 |  1 |  2 |  3 |  4 | , 1
// |  0 |  2 |  3 |  4 |  5 | , 2
// |  0 |  3 |  4 |  5 |  6 | , 3
// |  0 |  4 |  5 |  6 |  7 | , 4
//    0    1    2    3    4

// |  0 |  0 |  0 |  0 |  0 | , 0
// |  0 |  1 |  3 |  6 | 10 | , 1
// |  0 |  3 |  8 | 15 | 24 | , 2
// |  0 |  7 | 16 | 28 | 43 | , 3
// |  0 | 11 | 25 | 43 | 65 | , 4
//    0    1    2    3    4

// if (2, 2) ~ (4, 4)
// 65 - 10 - 11 + 1 = 45
// (4, 4) - (1, 4) - (4, 1) + (1, 1)
// 어때여??
// 45
// 3 ,3 ~ 4,4
// 65 - 24 - 25 + 8;
// 24
// 맞는 것 같습니다.

// 3 + 3 + 3 - 1 = 8
// 4 + 6 + 8 - 3  = 15
// 6 + 24 + 28 -15 = 43
