package beakjoon.no15퇴각검색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2661 {

    static boolean flag;

    static String result = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = "";
        int n = Integer.parseInt(br.readLine());

        flag = false;
        recursion(result, n);

        bw.write(result);

        bw.flush();
        bw.close();
    }

    public static void recursion(String current, int n) {
        if (flag) {
            return;
        }

        if (current.length() == n) {
            flag = true;
            result = current;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(isBad(current + i)) {
                continue;
            }
            recursion(current + i, n);
        }
    }

    public static boolean isBad(String result) {

        for (int size = 1; size <= result.length(); size++) {
            for (int j = 0; j + 2 * size <= result.length(); j++) {
                String left = result.substring(j, j + size);
                String right = result.substring(j + size, j + size * 2);
                // 123123213
                // 0, 1
                //
                if (left.equals(right)) {
                    return true;
                }
            }
        }

        return false;
    }
}

//    public static void recursion(List<String> result, int n) {
//        if (valid(result)) {
//            return;
//        }
//
//        if (result.size() == n) {
//            flag = true;
//            return;
//        }
//
//        for (int i = 1; i <= 3; i++) {
//            result.add(i + "");
//            recursion(result, n);
//            if (flag) {
//                return;
//            }
//            result.remove(result.size() - 1);
//        }
//    }
//
//    public static boolean valid(List<String> result) {
//        for (int i = 1; i < result.size(); i++) {
//            int max = Math.min(i, result.size() - i);
//            String left = "";
//            String right = "";
//            for (int j = 0; j < max; j++) {
//                left = result.get(i - 1 - j) + left;
//                right += result.get(i + j);
//
//                if (left.equals(right)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
