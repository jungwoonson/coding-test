package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] items = new String[n];

        for (int i = 0; i < items.length; i++) {
            items[i] = br.readLine();
        }

        Arrays.sort(items);

        String name = "";
        int count = 0;

        String maxName = "";
        int max = 0;
        for (int i = 0; i < items.length; i++) {
            if (!name.equals(items[i])) {
                name = items[i];
                count = 0;
            }

            count++;
            if (max < count) {
                max = count;
                maxName = items[i];
            }
        }

        bw.write(maxName);

        bw.flush();
        bw.close();
    }
}

