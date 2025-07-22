package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // Constraints:
    // 1 <= nums.length <= 10^5
    // -10^9 <= nums[i] <= 10^9
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
