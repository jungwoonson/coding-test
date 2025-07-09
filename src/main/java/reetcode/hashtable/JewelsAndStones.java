package reetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    // Constraints:
    // 1 <= jewels.length, stones.length <= 50
    // jewels and stones consist of only English letters.
    // All the characters of jewels are unique.
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        int result = 0;
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                result++;
            }
        }
        return result;
    }
}
