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

public class No14267 {

    public static BufferedWriter bw;
    static int n;

    public static class person {
        int count = 0;
        List<Integer> children = new ArrayList<>();

        public void add(int count) {
            this.count += count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        Map<Integer, person> company = new HashMap<>();
        String[] people = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            company.put(i, new person());
        }

        int start = 0;
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(people[i - 1]);
            if (parent == -1) {
                start = i;
            } else {
                company.get(parent).children.add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            int count = Integer.parseInt(inputs[1]);

            company.get(num).count += count;
        }

        function(company, start, 0);

        for (int i = 1; i <= n; i++) {
            bw.write(company.get(i).count + "");
            if (i != n) {
                bw.write(" ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void function(Map<Integer, person> company, int start, int count) {
        person person = company.get(start);
        person.add(count);
        for (int child : person.children) {
            function(company, child, person.count);
        }
    }
}
