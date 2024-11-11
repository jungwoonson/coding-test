package beakjoon.no011스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split("");
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            for (String word : input) {
                if (word.equals("<")) {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    continue;
                }
                if (word.equals(">")) {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    continue;
                }
                if (word.equals("-")) {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    continue;
                }
                left.push(word);
            }

            for (String s : left) {
                bw.write(s);
            }
            while (!right.isEmpty()) {
                bw.write(right.pop());
            }
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}