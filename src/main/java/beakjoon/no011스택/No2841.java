package beakjoon.no011스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No2841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        Stack<Integer>[] stacks = new Stack[500000];

        int count = 0;

        for (int i = 0; i < n; i++) {
            String[] melody = br.readLine().split(" ");
            int lineNum = Integer.parseInt(melody[0]);
            int fret = Integer.parseInt(melody[1]);

            if (stacks[lineNum] == null) {
                stacks[lineNum] = new Stack<>();
            }

            Stack<Integer> stack = stacks[lineNum];
            while (!stack.isEmpty() && stack.peek() > fret) {
                stack.pop();
                count++;
                if (stack.isEmpty()) {
                    break;
                }
            }

            if (!stack.isEmpty() && stack.peek() == fret) {
                continue;
            }

            stack.push(fret);
            count++;
        }

        bw.write(count + "");

        bw.flush();
        bw.close();
    }
}