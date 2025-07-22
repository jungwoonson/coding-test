package leetcode.queueandstack;

import java.util.Stack;

class DecodeString {

    // Constraints:
    // 1 <= s.length <= 30
    // s consists of lowercase English letters, digits, and square brackets '[]'.
    // s is guaranteed to be a valid input.
    // All the integers in s are in the range [1, 300].
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // 두 자리 이상 숫자 고려
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(currentStr.toString());
                num = 0;
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int i = 0; i < repeat; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                currentStr.append(ch);
            }
        }

        return currentStr.toString();
    }
}
