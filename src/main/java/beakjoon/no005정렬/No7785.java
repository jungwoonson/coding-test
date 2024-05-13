package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[][] infos = new String[count][2];

        for (int i = 0; i < infos.length; i++) {
            String[] record = br.readLine().split(" ");
            infos[i][0] = record[0];
            infos[i][1] = record[1];
        }

        Arrays.sort(infos, (o1, o2) -> o2[0].compareTo(o1[0]));

        for (int i = 0; i < count - 1; i++) {
            if (infos[i][1].equals("enter") && !infos[i][0].equals(infos[i + 1][0])) {
                bw.write(infos[i][0] + System.lineSeparator());
            }
        }
        if (infos[count - 1][1].equals("enter")) {
            bw.write(infos[count - 1][0] + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}
