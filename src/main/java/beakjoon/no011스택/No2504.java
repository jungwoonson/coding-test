package beakjoon.no011스택;

import java.io.*;
import java.util.Stack;

public class No2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] charArray = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        for (final String bracket : charArray) {
            if (bracket.equals("(") || bracket.equals("[")) {
                stack.add(bracket);
                continue;
            }

            if (stack.isEmpty()) {
                stack.add("0");
                break;
            }

            final String pop = stack.pop();

            if (pop.equals("(") || pop.equals("[")) {
                if (pop.equals("(") && bracket.equals(")")) {
                    stack.add("2");
                    continue;
                }
                if (pop.equals("[") && bracket.equals("]")) {
                    stack.add("3");
                    continue;
                }
                stack.clear();
                stack.add("0");
                break;
            }

            int sum = 0;
            sum = Integer.parseInt(pop);

            while (!stack.isEmpty() && !"([".contains(stack.peek())) {
                sum += Integer.parseInt(stack.pop());
            }

            if (stack.isEmpty()) {
                stack.add("0");
                break;
            }

            final String pop2 = stack.pop();

            if (pop2.equals("(") && bracket.equals(")")) {
                String num = String.valueOf(sum * 2);
                stack.add(num);
                continue;
            }

            if (pop2.equals("[") && bracket.equals("]")) {
                String num = String.valueOf(sum * 3);
                stack.add(num);
                continue;
            }

            stack.clear();
            stack.add("0");
            break;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            try {
                result += Integer.parseInt(stack.pop());
            } catch (NumberFormatException e) {
                result = 0;
                break;
            }
        }

        bw.write(result + System.lineSeparator());

        bw.flush();
        bw.close();
    }
}
