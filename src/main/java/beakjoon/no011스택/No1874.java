package beakjoon.no011스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class No1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> input = new LinkedList<>();

        Stack<Integer> answer = new Stack<>();
        StringBuilder result = new StringBuilder();
        Boolean success = false;
        int currentValue = 1;

        for (int i = 0; i < n; i++) {
            input.add(Integer.parseInt(br.readLine()));
        }

        while (!input.isEmpty()) {
            Integer target = input.poll();
            while (currentValue <= target) {
                answer.push(currentValue);
                result.append("+" + System.lineSeparator());
                currentValue++;
            }

            Integer peek = answer.peek();
            if (Objects.equals(peek, target)) {
                answer.pop();
                result.append("-" + System.lineSeparator());
            } else {
                bw.write("NO");
                success = true;
                break;
            }
        }

        if (!success) {
            bw.write(result.toString());
        }

        bw.flush();
        bw.close();
    }
}