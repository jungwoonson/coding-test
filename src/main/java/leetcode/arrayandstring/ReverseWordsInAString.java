package leetcode.arrayandstring;

public class ReverseWordsInAString {
    // Constraints:
    // 1 <= s.length <= 10^4
    // s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    // There is at least one word in s.
    public String reverseWords(String s) {
        s = " " + s;
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        int rightTarget = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!flag && s.charAt(i) != ' ') {
                rightTarget = i;
                flag = true;
                continue;
            }
            if (flag && s.charAt(i) == ' ') {
                flag = false;
                for (int j = i + 1; j <= rightTarget; j++) {
                    result.append(s.charAt(j));
                }
                result.append(' ');
            }
        }
        return result.toString().trim();
    }
}
