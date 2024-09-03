package beakjoon.no005정렬;

import java.io.*;
import java.util.*;

public class No18870_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Set<String> inputSet = new HashSet<>(Arrays.asList(input));

        String[] positionList = inputSet.toArray(new String[0]);

        Arrays.sort(positionList, (o1, o2) -> {
            int num1 = Integer.parseInt(o1);
            int num2 = Integer.parseInt(o2);

            return num1 - num2;
        });

        Map<String, Integer> posMap = new HashMap<>();

        for (int i = 0; i < positionList.length; i++) {
            posMap.put(positionList[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            bw.write(posMap.get(input[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}
