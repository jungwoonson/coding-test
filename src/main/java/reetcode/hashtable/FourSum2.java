package reetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    // Constraints:
    // n == nums1.length
    // n == nums2.length
    // n == nums3.length
    // n == nums4.length
    // 1 <= n <= 200
    // -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = -(c + d);
                count += map.getOrDefault(sum, 0);
            }
        }

        return count;
    }
}
