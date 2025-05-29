package reetcode.arrayandstring;

public class ReverseWordsInAString3 {
    // Constraints:
    // 1 <= s.length <= 5 * 10^4
    // s contains printable ASCII characters.
    // s does not contain any leading or trailing spaces.
    // There is at least one word in s.
    // All the words in s are separated by a single space.
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int target = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1|| s.charAt(i + 1) == ' ') {
                for (int j = i; j >= target; j--) {
                    result.append(s.charAt(j));
                }
                result.append(' ');
                target = i + 2;
            }
        }
        return result.toString().trim();
    }

    //
    public String reverseWords2(String s) {
        String[] split = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String string : split) {
            for (int i = string.length() - 1; i >= 0; i--) {
                result.append(string.charAt(i));
            }
            result.append(' ');
        }
        return result.toString().trim();
    }
}
