package beakjoon.no15퇴각검색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class No10597 {

    static boolean found ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numbers = br.readLine();
        int max = max(numbers);
        boolean[] check = new boolean[max + 1];
        List<String> result = new ArrayList<>();

        found = false;
        recursion(check, numbers, result, max);
        for (String num : result) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
    }

    private static int max(String numbers) {
        if (numbers.length() < 10) {
            return numbers.length();
        }
        return 9 + ((numbers.length() - 9) / 2);
    }

    public static void recursion(boolean[] check, String numbers, List<String> result, int max) {
        if (result.size() == max) {
            found = true;
            return;
        }

        for (int i = 1; i < max + 1; i++) {
            String a = String.valueOf(i);
            if (!numbers.startsWith(a) || check[i]) {
                continue;
            }
            numbers = numbers.replaceFirst(a, "");
            check[i] = true;
            result.add(a);
            recursion(check, numbers, result, max);

            if (found) {
                return;
            }

            result.remove(result.size() - 1);
            check[i] = false;
            numbers = a + numbers;
        }
    }
}
