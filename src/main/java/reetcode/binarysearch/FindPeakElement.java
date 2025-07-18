package reetcode.binarysearch;

public class FindPeakElement {

    // Constraints:
    // 1 <= nums.length <= 1000
    // -2^31 <= nums[i] <= 2^31 - 1
    // nums[i] != nums[i + 1] for all valid i.
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((mid + 1 >= nums.length || nums[mid] > nums[mid + 1])
                    && ((mid - 1 < 0) || nums[mid] > nums[mid - 1])) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }

        return left;
    }
}
