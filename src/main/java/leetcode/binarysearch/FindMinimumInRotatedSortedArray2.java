package leetcode.binarysearch;

public class FindMinimumInRotatedSortedArray2 {

    // Constraints:
    // n == nums.length
    // 1 <= n <= 5000
    // -5000 <= nums[i] <= 5000
    // nums is sorted and rotated between 1 and n times.

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[low] > nums[high]) {
                if (nums[mid] < nums[low]) {
                    high = mid;
                    continue;
                }
                low = mid + 1;
                continue;
            }
            if (nums[low] == nums[high]) {
                low++;
                continue;
            }
            return nums[low];
        }

        return nums[low];
    }
}
