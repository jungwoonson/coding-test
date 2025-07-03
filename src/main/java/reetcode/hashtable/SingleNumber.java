package reetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    // Constraints:
    // 1 <= nums.length <= 10^5
    // -10^9 <= nums[i] <= 10^9
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
