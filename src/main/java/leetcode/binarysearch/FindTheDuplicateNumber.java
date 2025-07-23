package leetcode.binarysearch;

public class FindTheDuplicateNumber {

    // Constraints:
    // 1 <= n <= 10^5
    // nums.length == n + 1
    // 1 <= nums[i] <= n
    // All the integers in nums appear only once except for precisely one integer which appears two or more times.

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        return left;
    }
}
