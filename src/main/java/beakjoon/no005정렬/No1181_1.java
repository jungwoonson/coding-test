package beakjoon.no005정렬;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No1181_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        words = wordSet.toArray(new String[wordSet.size()]);

        Arrays.sort(words, (o1, o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();

            if (length1 == length2) {
                return o1.compareTo(o2);
            }

            return length1 - length2;
        });

        for (int i = 0; i < words.length; i++) {
            bw.write(words[i]);
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}
