package leetcode.binarysearch;

public class BinarySearch {

    // Constraints:
    // 1 <= nums.length <= 10^4
    // -10^4 < nums[i], target < 10^4
    // All the integers in nums are unique.
    // nums is sorted in ascending order.
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
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
}
