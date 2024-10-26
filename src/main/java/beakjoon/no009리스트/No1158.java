package beakjoon.no009리스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class No1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        List<Integer> list = IntStream.range(1, n + 1)
            .collect(LinkedList::new, List::add, List::addAll);

        bw.write("<");
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + k - 1) % (list.size());

            bw.write(list.remove(index) + "");
            if (!list.isEmpty()) {
                bw.write(", ");
            }
        }
        bw.write(">");



        bw.flush();
        bw.close();
    }
}