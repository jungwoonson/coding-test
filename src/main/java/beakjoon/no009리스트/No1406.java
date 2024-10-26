package beakjoon.no009리스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class No1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<String> words = new LinkedList<>(Arrays.asList(br.readLine().split("")));

        int m = Integer.parseInt(br.readLine());

        ListIterator<String> it = words.listIterator(words.size());

        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("L")) {
                if (it.hasPrevious()) {
                    it.previous();
                }
            } else if (command[0].equals("D")) {
                if (it.hasNext()) {
                    it.next();
                }
            } else if (command[0].equals("B")) {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else {
                it.add(command[1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}