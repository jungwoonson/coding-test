package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // Constraints:
    // 0 <= s.length <= 5 * 10^4
    // s consists of English letters, digits, symbols and spaces.
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        int end = 0;
        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                while (start < s.length()) {
                    set.remove(s.charAt(start));
                    start++;
                    if (s.charAt(start - 1) == s.charAt(end)) {
                        break;
                    }
                }
            }
            set.add(s.charAt(end));
            end++;
            max = Math.max(max, end - start);
        }
        return max;
    }
}
