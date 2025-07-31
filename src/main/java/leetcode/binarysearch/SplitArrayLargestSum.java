package leetcode.binarysearch;

public class SplitArrayLargestSum {

    // Constraints:
    // 1 <= nums.length <= 1000
    // 0 <= nums[i] <= 10^6
    // 1 <= k <= min(50, nums.length)
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = getSum(nums);

        while (low < high) {
            int mid = low + (high - low) / 2;

            int splitCount = countSplit(nums, mid);
            if (splitCount > k) {
                low = mid + 1;
                continue;
            }
            high = mid;
        }

        return low;
    }

    private int countSplit(int[] nums, int max) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (num > max) {
                return Integer.MAX_VALUE;
            }
            sum += num;
            if (sum > max) {
                count++;
                sum = num;
            }
        }
        return count;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
