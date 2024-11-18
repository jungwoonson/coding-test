package beakjoon.no013재귀트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No15681 {

    public static BufferedWriter bw;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int r = Integer.parseInt(first[1]);
        int q = Integer.parseInt(first[2]);

        Map<Integer, List<Integer>> tree = new HashMap<>();

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

        result = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        findRoot(tree, r, visited);

        for (int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine());
            bw.write(result[u] + System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }

    public static int findRoot(Map<Integer, List<Integer>> tree, int startNode, boolean[] visited) {
        visited[startNode] = true;
        int size = 1;
        for (int child : tree.get(startNode)) {
            if (!visited[child]) {
                size += findRoot(tree, child, visited);
            }
        }
        result[startNode] = size;
        return size;
    }
}
