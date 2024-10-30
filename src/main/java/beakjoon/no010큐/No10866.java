package beakjoon.no010큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class No10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            String value = "";
            if (input.length > 1) {
                value = input[1];
            }

            if (command.equals("push_front")) {
                pushFront(deque, value);
            } else if (command.equals("push_back")) {
                pushBack(deque, value);
            } else if (command.equals("pop_front")) {
                popFront(deque, bw);
            } else if (command.equals("pop_back")) {
                popBack(deque, bw);
            } else if (command.equals("size")) {
                size(deque, bw);
            } else if (command.equals("empty")) {
                empty(deque, bw);
            } else if (command.equals("front")) {
                front(deque, bw);
            } else if (command.equals("back")) {
                back(deque, bw);
            }
        }

        bw.flush();
        bw.close();
    }

    private static void pushFront(Deque<String> deque, String value) {
        deque.addFirst(value);
    }

    private static void pushBack(Deque<String> deque, String value) {
        deque.addLast(value);
    }

    private static void popFront(Deque<String> deque, BufferedWriter bw) throws IOException {
        if (deque.isEmpty()) {
            bw.write("-1" + System.lineSeparator());
            return;
        }
        bw.write(deque.removeFirst() + System.lineSeparator());
    }

    private static void popBack(Deque<String> deque, BufferedWriter bw) throws IOException {
        if (deque.isEmpty()) {
            bw.write("-1" + System.lineSeparator());
            return;
        }
        bw.write(deque.removeLast() + System.lineSeparator());
    }

    private static void size(Deque<String> deque, BufferedWriter bw) throws IOException {
        bw.write(deque.size() + System.lineSeparator());
    }

    private static void empty(Deque<String> deque, BufferedWriter bw) throws IOException {
        if (deque.isEmpty()) {
            bw.write("1" + System.lineSeparator());
            return;
        }
        bw.write("0" + System.lineSeparator());
    }

    private static void front(Deque<String> deque, BufferedWriter bw) throws IOException {
        if (deque.isEmpty()) {
            bw.write("-1" + System.lineSeparator());
            return;
        }
        bw.write(deque.peekFirst() + System.lineSeparator());
    }

    private static void back(Deque<String> deque, BufferedWriter bw) throws IOException {
        if (deque.isEmpty()) {
           bw.write("-1" + System.lineSeparator());
           return;
        }
        bw.write(deque.peekLast() + System.lineSeparator());
    }
}