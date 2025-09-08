package leetcode.binarysearchtree;

import java.util.TreeSet;

public class ContainsDuplicate3 {

    // Constraints:
    // 2 <= nums.length <= 10^5
    // -10^9 <= nums[i] <= 10^9
    // 1 <= indexDiff <= nums.length
    // 0 <= valueDiff <= 10^9
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0) {
            return false;
        }
        if (valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];

            Long floor = set.floor(x);
            if (floor != null) {
                if (x - floor <= valueDiff) {
                    return true;
                }
            }

            Long ceil = set.ceiling(x);
            if (ceil != null) {
                if (ceil - x <= valueDiff) {
                    return true;
                }
            }

            set.add(x);

            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
