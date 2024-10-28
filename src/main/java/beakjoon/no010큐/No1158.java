package beakjoon.no010큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class No1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Queue<Integer> queue = IntStream.range(1, n + 1)
            .collect(LinkedList::new, List::add, List::addAll);

        bw.write("<");
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                queue.add(queue.poll());
            }
            bw.write(queue.poll() + "");
            if (i < n - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
    }
}