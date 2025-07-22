package leetcode.arrayandstring;

public class PlusOne {
    // Constraints:
    // 1 <= digits.length <= 100
    // 0 <= digits[i] <= 9
    // digits does not contain any leading 0's.
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        if (digits[digits.length - 1] <= 9) {
            return digits;
        }

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            }
        }

        if (digits[0] != 10) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
