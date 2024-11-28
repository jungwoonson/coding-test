package beakjoon.no014재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No1759 {

    public static BufferedWriter bw;
    public static int result = 0;
    public static int l = 0;
    public static int c = 0;
    public static String aeiou = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        l = Integer.parseInt(first[0]);
        c = Integer.parseInt(first[1]);

        String[] words = br.readLine().split(" ");
        Arrays.sort(words);
        String[] result = new String[l];

        function(0, 0, words, result);

        bw.flush();
        bw.close();
    }

    public static void function(int depth, int index, String[] words, String[] result)
        throws IOException {
        if (l == depth) {
            if (!valid(result)) {
                return;
            }
            for (int i = 0; i < result.length; i++) {
                bw.write(result[i] + "");
            }
            bw.write(System.lineSeparator());
            return;
        }

        for (int i = index; i < words.length; i++) {
            result[depth] = words[i];
            function(depth + 1, i + 1, words, result);
        }
    }

    public static boolean valid(String[] result) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < result.length; i++) {
            if (isVowel(result[i])) {
                vowelCount++;
                continue;
            }
            consonantCount++;
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }

    public static boolean isVowel(String value) {
        return aeiou.contains(value);
    }
}

//4 6
//a c i s t w

//acis
//acit
//aciw
//acst
//acsw
//actw
//aist
//aisw
//aitw
//astw
//cist
//cisw
//citw
//istw
