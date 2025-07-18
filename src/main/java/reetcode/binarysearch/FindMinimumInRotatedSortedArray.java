package reetcode.binarysearch;

public class FindMinimumInRotatedSortedArray {

    // Constraints:
    // n == nums.length
    // 1 <= n <= 5000
    // -5000 <= nums[i] <= 5000
    // All the integers of nums are unique.
    // nums is sorted and rotated between 1 and n times.

    // 4 5 6 7 8 9 0 1 2 3
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }

        return nums[left];
    }
}
