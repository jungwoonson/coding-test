package reetcode.queueandstack;

import java.util.Stack;

class ValidParentheses {

    // Constraints:
    // 1 <= s.length <= 10^4
    // s consists of parentheses only '()[]{}'.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            Character pop = stack.pop();
            if ((bracket == ')' && pop == '(') || (bracket == '}' && pop == '{') || (bracket == ']' && pop == '[')) {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
