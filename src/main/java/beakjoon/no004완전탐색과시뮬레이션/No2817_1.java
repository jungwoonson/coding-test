package beakjoon.no004완전탐색과시뮬레이션;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No2817_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int people = Integer.parseInt(br.readLine());
        int staff = Integer.parseInt(br.readLine());

        Map<String, Integer> voteMap = new HashMap<>();

        for (int i = 0; i < staff; i++) {
            String[] line = br.readLine().split(" ");
            String name = line[0];
            int vote = Integer.parseInt(line[1]);

            if (vote < people * 0.05) {
                continue;
            }
            voteMap.put(name, vote);
        }

        List<int[]> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {

            for (int i = 1; i <= 14; i++) {
                String name = entry.getKey();
                int vote = entry.getValue();
                int[] result = new int[2];
                result[0] = name.charAt(0);
                result[1] = (vote / i);
                resultList.add(result);
            }

        }

        resultList.sort((o1, o2) -> o2[1] - o1[1]);

        for (String key : voteMap.keySet()) {
            voteMap.put(key,0);
        }

        for (int i = 0; i < 14; i++) {
            char name = (char)resultList.get(i)[0];

            voteMap.put(Character.toString(name), voteMap.getOrDefault(Character.toString(name), 0) + 1);
        }

        for (int i = 'A'; i < 'Z'; i++) {
            String name = Character.toString((char) i);
            if (voteMap.containsKey(name)) {
                bw.write(name + " " + voteMap.get(name));
                bw.write(System.lineSeparator());
            }
        }

        bw.write(System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
