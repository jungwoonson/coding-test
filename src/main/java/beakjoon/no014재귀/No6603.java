package beakjoon.no014재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No6603 {

    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            if (line[0] == 0) {
                break;
            }

            int[] result = new int[6];
            function(0, line, 1, result);
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static void function(int depth, int[] array, int index, int[] result)
        throws IOException {
        if (depth == 6) {
            for (int i = 0; i < result.length; i++) {
                bw.write(result[i] + "");
                if (i != result.length - 1) {
                    bw.write(" ");
                }
            }
            bw.write(System.lineSeparator());
            return;
        }

        for (int i = index; i < array.length; i++) {
            result[depth] = array[i];
            function(depth + 1, array, i + 1, result);
        }
    }
}
