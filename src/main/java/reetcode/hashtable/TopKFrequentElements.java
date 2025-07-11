package reetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

    // Constraints:
    // 1 <= nums.length <= 10^5
    // -10^4 <= nums[i] <= 10^4
    // k is in the range [1, the number of unique elements in the array].
    // It is guaranteed that the answer is unique.
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[][] values =  new Integer[map.size()][2];
        int index = 0;
        for (Integer key : map.keySet()) {
            values[index][0] = map.get(key);
            values[index++][1] = key;
        }
        Arrays.sort(values, (o1, o2) -> o2[0].compareTo(o1[0]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = values[i][1];
        }
        return result;
    }
}
