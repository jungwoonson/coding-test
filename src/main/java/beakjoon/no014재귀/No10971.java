package beakjoon.no014재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10971 {

    public static BufferedWriter bw;
    public static int result = Integer.MAX_VALUE;
    public static int n = 0;
    public static int[][] prices;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        prices = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                prices[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited[0] = true;
        function(0, 1, 0);

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static void function(int startCity, int depth, int sumPrice) {
        if(n == depth) {
            if (prices[startCity][0] > 0) {
                if (result > sumPrice + prices[startCity][0]) {
                    result = sumPrice + prices[startCity][0];
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || prices[startCity][i] == 0) {
                continue;
            }

            visited[i] = true;
            function(i, depth + 1, sumPrice + prices[startCity][i]);
            visited[i] = false;
        }
    }
}
