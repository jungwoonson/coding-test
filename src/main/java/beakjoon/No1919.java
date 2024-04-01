package beakjoon;

public class No1919 {

    public int answer(String a, String b) {
        int[] countA = countAlphabet(a);
        int[] countB = countAlphabet(b);

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(countA[i] - countB[i]);
        }
        return result;
    }

    public int[] countAlphabet(String value) {
        int[] count = new int[26];
        for (int i = 0; i < value.length(); i++) {
            count[value.charAt(i) - 'a']++;
        }
        return count;
    }
}
