package beakjoon.no011스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class No4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")){
                break;
            }
            bw.write(isBalance(line) + System.lineSeparator());
        }
        bw.flush();
        bw.close();
    }

    public static String isBalance(String line) {

        Deque<Character> balance = new LinkedList<>();

        for (Character c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                balance.add(c);
                continue;
            }
            if (c != ')' && c != ']') {
                continue;
            }
            if (!isValid(c, balance)) {
                return "no";
            }
        }

        if(balance.isEmpty()) {
            return "yes";
        }
        return "no";
    }

    private static boolean isValid(Character c, Deque<Character> balance) {
        Character poll = balance.pollLast();
        if (poll == null) {
            return false;
        }
        if (poll != '(' && c == ')') {
            return false;
        }
        if (poll != '[' && c == ']'){
            return false;
        }
        return true;
    }
}