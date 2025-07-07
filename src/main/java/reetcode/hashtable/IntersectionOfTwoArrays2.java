package reetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

    // Constraints:
    // 1 <= nums1.length, nums2.length <= 1000
    // 0 <= nums1[i], nums2[i] <= 1000
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : nums1) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int it : nums2) {
            if (map.containsKey(it) && map.get(it) > 0) {
                list.add(it);
                map.put(it, map.get(it) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
