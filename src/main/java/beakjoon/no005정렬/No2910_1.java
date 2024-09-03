package beakjoon.no005정렬;

import java.io.*;
import java.util.*;


public class No2910_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int c = Integer.parseInt(line.split(" ")[1]);

        String[] line2 = br.readLine().split(" ");

        Map<String, Integer> lineCountMap = new HashMap<>();
        Map<String, Integer> lineIndexMap = new HashMap<>();

        int index = 0;
        for (int i = 0; i < line2.length; i++) {
            lineCountMap.put(line2[i], lineCountMap.getOrDefault(line2[i], 0) + 1);
            if (!lineIndexMap.containsKey(line2[i])) {
                lineIndexMap.put(line2[i], index);
                index++;
            }
        }

        line2 = lineCountMap.keySet()
                .toArray(new String[0]);

        Arrays.sort(line2, (o1, o2) -> {
            if (Objects.equals(lineCountMap.get(o1), lineCountMap.get(o2))) {
                return lineIndexMap.get(o1) - lineIndexMap.get(o2);
            }
            return lineCountMap.get(o2) - lineCountMap.get(o1);
        });

        for (String s : line2) {
            if (lineCountMap.containsKey(s)) {
                for (int j = 0; j < lineCountMap.get(s); j++) {
                    bw.write(s + " ");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

