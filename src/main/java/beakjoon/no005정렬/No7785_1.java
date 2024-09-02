package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No7785_1 {

    private static final String ENTER = "enter";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = br.readLine();
        }

        Arrays.sort(list, (o1, o2) -> {
            String name1 = o1.split(" ")[0];
            String name2 = o2.split(" ")[0];

            return name2.compareTo(name1);
        });

        for (int i = 0; i < list.length; i++) {
            String name = list[i].split(" ")[0];
            String status = list[i].split(" ")[1];

            String nextName = "";
            if (i + 1 < list.length) {
                nextName = list[i + 1].split(" ")[0];
            }

            if (nextName.isEmpty() && status.equals(ENTER)) {
                bw.write(name + System.lineSeparator());
            } else if (!name.equals(nextName) && status.equals(ENTER)) {
                bw.write(name + System.lineSeparator());
            }
        }

        bw.flush();
        bw.close();
    }
}
