package beakjoon.no005정렬;

import java.io.*;
import java.util.*;

public class No2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");
        String[] lint2 = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String key : lint2) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        Arrays.sort(lint2, (o1, o2) -> map.get(o2) - map.get(o1));

        for (String key : lint2) {
            if (!map.containsKey(key)) {
                continue;
            }
            for (int i = 0; i < map.get(key); i++) {
                bw.write(key + " ");
            }
            map.remove(key);
        }

        bw.flush();
        bw.close();
    }
}
