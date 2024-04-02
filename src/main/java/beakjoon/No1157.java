package beakjoon;

public class No1157 {

    public char answer(String value) {
        String upperValue = value.toUpperCase();

        int[] count = new int[26];
        for (int i = 0; i < upperValue.length(); i++) {
            count[upperValue.charAt(i) - 'A']++;
        }

        char answer = '?';
        int max = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A');
            }
        }

        int duplicateMaxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                duplicateMaxCount++;
            }

            if (duplicateMaxCount >= 2) {
                return '?';
            }
        }

        return answer;
    }
}
