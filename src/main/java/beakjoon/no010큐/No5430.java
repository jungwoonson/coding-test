package beakjoon.no010큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class No5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(",");
            arr[0] = arr[0].substring(1);
            arr[arr.length - 1] = arr[arr.length - 1].substring(0,
                arr[arr.length - 1].length() - 1);
            Deque<String> deque = Arrays.stream(arr)
                .collect(Collectors.toCollection(LinkedList::new));

            boolean arrow = true;
            boolean flag = false;

            for (String func : p) {
                if (func.equals("R")) {
                    arrow = !arrow;
                } else {
                    if (deque.isEmpty() || deque.peekFirst().isEmpty()) {
                        bw.write("error" + System.lineSeparator());
                        flag = true;
                        break;
                    }

                    if (arrow) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (flag) {
                continue;
            }

            if (arrow) {
                String collect = String.join(",", deque);
                bw.write("[" + collect + "]" + System.lineSeparator());
            } else {
                bw.write("[");
                while (!deque.isEmpty()) {
                    bw.write(deque.pollLast());
                    if (!deque.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]" + System.lineSeparator());
            }
        }

        bw.flush();
        bw.close();
    }
}
