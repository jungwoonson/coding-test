package beakjoon.no005정렬;

import java.io.*;
import java.util.*;

public class No10814_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Map<String, Object>> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] personInfo = br.readLine().split(" ");
            int age = Integer.parseInt(personInfo[0]);
            String name = personInfo[1];

            Map<String, Object> person = new HashMap<>();

            person.put("index", i);
            person.put("age", age);
            person.put("name", name);

            people.add(person);
        }

        people.sort((o1, o2) -> {
            int age1 = (int) o1.get("age");
            int age2 = (int) o2.get("age");

            return age1 - age2;
        });

        for (Map<String, Object> person : people) {
            bw.write(person.get("age").toString() + " " + person.get("name"));
            bw.write(System.lineSeparator());
        }

        bw.flush();
        bw.close();
    }
}
