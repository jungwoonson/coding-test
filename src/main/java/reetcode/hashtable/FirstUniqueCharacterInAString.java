package reetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    // Constraints:
    // 1 <= s.length <= 10^5
    // s consists of only lowercase English letters.
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
