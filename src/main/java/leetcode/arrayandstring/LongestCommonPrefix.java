package leetcode.arrayandstring;

public class LongestCommonPrefix {
    // Constraints:
    // 1 <= strs.length <= 200
    // 0 <= strs[i].length <= 200
    // strs[i] consists of only lowercase English letters if it is non-empty.
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        for (int i = minLength; i > 0; i--) {
            String value = "";
            boolean found = true;
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    value = strs[j].substring(0, i);
                    continue;
                }
                if (!value.equals(strs[j].substring(0, i))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return strs[0].substring(0, i);
            }
        }
        return "";
    }
}
