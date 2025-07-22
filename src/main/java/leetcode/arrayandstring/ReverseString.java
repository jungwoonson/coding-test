package leetcode.arrayandstring;

public class ReverseString {
    // Constraints:
    // 1 <= s.length <= 10^5
    // s[i] is a printable ascii character.
    public void reverseString(char[] s) {
        int front = 0;
        int rear = s.length - 1;

        while (front < rear) {
            char temp = s[front];
            s[front] = s[rear];
            s[rear] = temp;
            front++;
            rear--;
        }
    }
}
