package beakjoon;

import java.io.*;
import java.util.Arrays;

public class No10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] infos = new String[count];

        for (int i = 0; i < infos.length; i++) {
            infos[i] = br.readLine();
        }

        Arrays.sort(infos, (o1, o2) -> {
            int o1Age = Integer.parseInt(o1.split(" ")[0]);
            int o2Age = Integer.parseInt(o2.split(" ")[0]);

            return o1Age - o2Age;
        });

        for (int i = 0; i < infos.length; i++) {
            bw.write(infos[i] + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}
