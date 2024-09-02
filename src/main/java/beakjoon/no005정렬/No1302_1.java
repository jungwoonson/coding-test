package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1302_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
        }

        int max = 0;
        String bookName = "";
        String[] keys = bookMap.keySet()
                .toArray(new String[0]);
        Arrays.sort(keys);

        for (String key : keys) {
            if (bookMap.get(key) > max) {
                bookName = key;
                max = bookMap.get(key);
            }
        }

        bw.write(bookName + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
