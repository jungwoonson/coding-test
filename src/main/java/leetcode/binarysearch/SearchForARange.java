package leetcode.binarysearch;

public class SearchForARange {

    // Constraints:
    // 0 <= nums.length <= 105
    // -10^9 <= nums[i] <= 10^9
    // nums is a non-decreasing array.
    // -10^9 <= target <= 10^9

    // 5,7,7,8,8,10
    public int[] searchRange(int[] nums, int target) {
        return new int[]{start(nums, target), end(nums, target)};
    }

    private int start(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }

        return -1;
    }

    private int end(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == nums.length - 1 || nums[mid + 1] > target) && nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }

        return -1;
    }
}
