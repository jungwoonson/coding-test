package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // Constraints:
    // 1 <= nums1.length, nums2.length <= 1000
    // 0 <= nums1[i], nums2[i] <= 1000
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums1) {
                set.add(num);
            }
            Set<Integer> result = new HashSet<>();
            for (int num : nums2) {
                if (set.contains(num)) {
                    result.add(num);
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
}
