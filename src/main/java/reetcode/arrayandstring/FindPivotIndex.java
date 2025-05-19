package reetcode.arrayandstring;

public class FindPivotIndex {
    // Constraints:
    // 1 <= nums.length <= 10^4
    // -1000 <= nums[i] <= 1000
    public int pivotIndex(int[] nums) {
        int right = 0;
        for (int num : nums) {
            right += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
