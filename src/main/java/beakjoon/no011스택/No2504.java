package beakjoon.no011스택;

import java.io.*;
import java.util.Stack;

public class No2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArray = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int middleResult = 0;
        int temp = 0;
        boolean 이전에괄호가닫힘 = false;
        int[] resultArr = new int[20];
        int depth = 0;

        for (int i = 0; i < charArray.length; i++) {

        }

        bw.flush();
        bw.close();
    }
}