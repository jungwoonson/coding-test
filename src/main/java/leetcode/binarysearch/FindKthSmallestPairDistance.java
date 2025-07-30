package leetcode.binarysearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    // Constraints:
    // n == nums.length
    // 2 <= n <= 10^4
    // 0 <= nums[i] <= 10^6
    // 1 <= k <= n * (n - 1) / 2
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = count(nums, mid);

            if (count >= k) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        return left;
    }

    // 1 2 3 4 5 6 7 8 9
    public int count(int[] nums, int maxDist) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++;
            }

            count += right - left;
        }

        return count;
    }
}
