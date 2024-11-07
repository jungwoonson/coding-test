package beakjoon.no011스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No16120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ppapArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < ppapArr.length; i++) {
            stack.push(ppapArr[i]);

            if (stack.size() >= 4) {
                char four = stack.pop();
                char three = stack.pop();
                char two = stack.pop();
                char one = stack.pop();

                if (one == 'P' && two == 'P' && three == 'A' && four == 'P') {
                    stack.push('P');
                } else {
                    stack.push(one);
                    stack.push(two);
                    stack.push(three);
                    stack.push(four);
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
           bw.write("PPAP" + System.lineSeparator());
        } else {
            bw.write("NP" + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}