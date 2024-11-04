package beakjoon.no011스택;

import java.io.*;
import java.util.Stack;

public class No10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] stickArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < stickArr.length; i++) {
            if (stickArr[i] == '(') {
                stack.add('(');
            } else {
                stack.pop();
                if (stickArr[i - 1] == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }

        bw.write(count + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}