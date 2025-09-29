package leetcode.recursion;

public class ReverseString {

    // 1 <= s.length <= 10^5
    // s[i] is a printable ascii character.
    public void reverseString(char[] s) {
        recursion(s, 0);
    }

    public void recursion(char[] s, int index) {
        if (index == s.length / 2) {
            return;
        }

        char temp = s[index];
        s[index] = s[s.length - 1 - index];
        s[s.length - 1 - index] = temp;
        recursion(s, index + 1);
    }
}
