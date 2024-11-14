package beakjoon.no013재귀트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class No11725 {

    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int node1 = Integer.parseInt(inputs[0]);
            int node2 = Integer.parseInt(inputs[1]);
            List<Integer> list1 = tree.get(node1);
            list1.add(node2);

            List<Integer> list2 = tree.get(node2);
            list2.add(node1);
        }

        function(1, tree, result);

        for (int i = 2; i < result.length; i++) {
            bw.write(result[i] + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static void function(Integer target, Map<Integer, List<Integer>> tree, int[] result) {
        if (tree.get(target).isEmpty()) {
            return;
        }

        List<Integer> child = tree.get(target);
        for (Integer i : child) {
            result[i] = target;
            List<Integer> childList = tree.get(i);
            Iterator<Integer> iterator = childList.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next.equals(target)) {
                    iterator.remove();
                    break;
                }
            }
            function(i, tree, result);
        }
    }
}
