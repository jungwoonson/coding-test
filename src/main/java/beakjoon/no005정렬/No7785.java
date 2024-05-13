package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;

public class No7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] infos = new String[count];

        for (int i = 0; i < infos.length; i++) {
            infos[i] = br.readLine();
        }

        Arrays.sort(infos, (o1, o2) -> {
            String[] o1Split = o1.split(" ");
            String[] o2Split = o2.split(" ");

            String o1Name = o1Split[0];
            String o2Name = o2Split[0];

            String o1Value = o1Split[1];
            String o2Value = o2Split[1];

            if (o1Name.compareTo(o2Name) == 0) {
                return o1Value.compareTo(o2Value);
            }

            return o2Name.compareTo(o1Name);
        });

        String name = infos[0].split(" ")[0];
        int nameCount = 1;
        for (int i = 1; i < infos.length; i++) {
            String nowName = infos[i].split(" ")[0];
            if (name.equals(nowName)) {
                nameCount++;
                continue;
            }

            if (nameCount % 2 == 1) {
                bw.write(name + System.lineSeparator());
            }

            nameCount = 1;
            name = nowName;

            if (i == infos.length - 1) {
                bw.write(nowName + System.lineSeparator());
            }
        }

        bw.flush();
        bw.close();
    }
}
