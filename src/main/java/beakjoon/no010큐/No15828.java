package beakjoon.no010큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class No15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<String> buffer = new LinkedList<>();

        while (true) {
            String input = br.readLine();
            if (input.equals("-1")) {
                break;
            }

            if (input.equals("0")) {
                buffer.poll();
            } else if (buffer.size() < n) {
                buffer.add(input);
            }
        }

        for (String data : buffer) {
            bw.write(data + " ");
        }

        if (buffer.isEmpty()) {
            bw.write("empty");
        }

        bw.flush();
        bw.close();
    }
}