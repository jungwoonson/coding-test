package leetcode.arrayandstring;

public class AddBinary {
    // Constraints:
    // 1 <= a.length, b.length <= 10^4
    // a and b consist only of '0' or '1' characters.
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        int tempValue = 0;
        int sum = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int aValue = aIndex >= 0 ? a.charAt(aIndex--) - '0' : 0;
            int bValue = bIndex >= 0 ? b.charAt(bIndex--) - '0' : 0;

            sum = aValue + bValue + tempValue;
            if (sum >= 2) {
                tempValue = 1;
            } else {
                tempValue = 0;
            }
            result.append((char) (sum % 2 + '0'));
        }

        if (tempValue == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}
