package beakjoon;

import java.io.*;

public class No10448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int maxTriangularNumber = 44;

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            boolean flag = false;
            int target = Integer.parseInt(br.readLine());
            for (int j = 1; j <= maxTriangularNumber; j++) {
                for (int k = 1; k <= maxTriangularNumber; k++) {
                    for (int l = 1; l <= maxTriangularNumber; l++) {
                        if (triangularNumber(j) + triangularNumber(k) + triangularNumber(l) == target) {
                            bw.write("1" + System.lineSeparator());
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                bw.write("0" + System.lineSeparator());
            }
        }

        bw.flush();
        bw.close();
    }

    public static int triangularNumber(int n) {
        return (n * (n + 1)) / 2;
    }
}
