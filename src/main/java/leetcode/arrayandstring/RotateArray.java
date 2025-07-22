package leetcode.arrayandstring;

public class RotateArray {
    // Constraints:
    // 1 <= nums.length <= 10^5
    // -2^31 <= nums[i] <= 2^31 - 1
    // 0 <= k <= 10^5
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
