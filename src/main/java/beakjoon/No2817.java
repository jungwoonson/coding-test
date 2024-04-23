package beakjoon;

import java.io.*;

public class No2817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int participant = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int[] staffs = new int[26];
        double[][] result = new double[26][14];

        for (int i = 0; i < count; i++) {
            String[] info = br.readLine().split(" ");
            char name = info[0].charAt(0);
            int vote = Integer.parseInt(info[1]);
            if (vote < participant * 0.05) {
                continue;
            }

            for (int j = 0; j < 14; j++) {
                result[name - 'A'][j] = (double) vote / (double) (j + 1);
            }
        }

        bw.write("");

        bw.flush();
        bw.close();
    }
}

