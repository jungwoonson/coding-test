package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    // Constraints:
    // 1 <= s.length <= 5 * 10^4
    // t.length == s.length
    // s and t consist of any valid ascii character.
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }

        map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = t.charAt(i);
            char c2 = s.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }

        return true;
    }
}
