package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    // Constraints:
    // 1 <= nums.length <= 10^5
    // -10^9 <= nums[i] <= 10^9
    // 0 <= k <= 10^5
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length && i <= k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }
        int left = 0;
        int right = k + 1;
        while (right < nums.length) {
            map.put(nums[left], map.get(nums[left]) - 1);
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[right]) > 1) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    // map value에 count 값을 넣지 말고 index 값을 넣으면 반복분을 두 번 돌리지 않아도 된다.
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(nums[i])) {
                int prevIndex = store.get(nums[i]);
                if ((i - prevIndex) <= k) {
                    return true;
                }

            }
            store.put(nums[i], i);
        }
        return false;
    }
}
