package leetcode.binarysearch;

public class SearchInRotatedSortedArray {

    // Constraints:
    // 1 <= nums.length <= 5000
    // -10^4 <= nums[i] <= 10^4
    // All values of nums are unique.
    // nums is an ascending array that is possibly rotated.
    // -10^4 <= target <= 10^4
    public int search(int[] nums, int target) {
        int startIndex = findMinIndex(nums);

        int low = 0;
        int high = nums.length - 1;

        if (startIndex != 0) {
            if (nums[startIndex] <= target && nums[nums.length - 1] >= target) {
                low = startIndex;
            } else {
                high = startIndex - 1;
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int findMinIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums[low] <= nums[high]) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] > nums[mid]) {
                high = mid;
                continue;
            }
            if (nums[mid + 1] > nums[high] ) {
                low = mid + 1;
                continue;
            }
            return mid + 1;
        }

        return 0;
    }
}
