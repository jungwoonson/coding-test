package beakjoon;

import java.io.*;
import java.util.Arrays;

public class No1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] values = new String[count];

        for (int i = 0; i < values.length; i++) {
            values[i] = br.readLine();
        }

        Arrays.sort(values, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });

        String value = "";
        for (int i = 0; i < values.length; i++) {
            if (!value.equals(values[i])) {
                bw.write(values[i] + System.lineSeparator());
            }
            value = values[i];
        }

        bw.flush();
        bw.close();
    }
}
