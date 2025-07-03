package reetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    // Constraints:
    // 1 <= nums.length <= 3 * 10^4
    // -3 * 10^4 <= nums[i] <= 3 * 10^4
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        return set.iterator().next();
    }
}
