package leetcode.array;

public class RemoveDuplicatesFromSortedArray {
    // Constraints:
    // 1 <= nums.length <= 3 * 104
    // -100 <= nums[i] <= 100
    // nums is sorted in non-decreasing order.
    public int removeDuplicates(int[] nums) {
        int before = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (before < nums[i]) {
                before = nums[i];
                nums[i - count] = nums[i];
                continue;
            }
            count++;
        }
        return nums.length - count;
    }
}
