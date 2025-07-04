package reetcode.hashtable;

import java.util.HashMap;

public class TwoSum {

    // Constraints:
    // 2 <= nums.length <= 10^4
    // -10^9 <= nums[i] <= 10^9
    // -10^9 <= target <= 10^9
    // Only one valid answer exists.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{map.get(target - nums[nums.length - 1]), nums.length - 1};
    }
}
