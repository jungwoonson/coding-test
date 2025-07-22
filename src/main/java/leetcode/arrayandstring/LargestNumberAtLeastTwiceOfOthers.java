package leetcode.arrayandstring;

public class LargestNumberAtLeastTwiceOfOthers {
    // Constraints:
    // 2 <= nums.length <= 50
    // 0 <= nums[i] <= 100
    public int dominantIndex(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        int index = -1;
        int result = 0;
        for (int num : nums) {
            index++;
            if (num > first) {
                second = first;
                first = num;
                result = index;
                continue;
            }
            if (num > second) {
                second = num;
            }
        }
        return first >= second * 2 ? result : -1;
    }
}
