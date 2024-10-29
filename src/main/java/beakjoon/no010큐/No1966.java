package beakjoon.no010큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            Queue<Integer> queue = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(LinkedList::new, Queue::add, Queue::addAll);

            int pollCount = 0;
            while (!queue.isEmpty()) {

                int max = queue.stream()
                    .max(Integer::compareTo)
                    .get();

                Integer peek = queue.peek();

                if (peek == max) {
                    queue.poll();
                    pollCount++;
                    if (m == 0) {
                        break;
                    }
                    m--;
                    continue;
                }

                queue.add(queue.poll());
                m--;

                if (m < 0) {
                    m = queue.size() - 1;
                }
            }

            bw.write(pollCount + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}