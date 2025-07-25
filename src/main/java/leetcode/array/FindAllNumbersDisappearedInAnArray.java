package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    // Constraints:
    // n == nums.length
    // 1 <= n <= 10^5
    // 1 <= nums[i] <= n
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] counts = new int[nums.length + 1];
        for (int num : nums) {
            counts[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
