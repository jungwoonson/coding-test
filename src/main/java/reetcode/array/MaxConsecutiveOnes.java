package reetcode.array;

public class MaxConsecutiveOnes {
    // Given a binary array nums, return the maximum number of consecutive 1's in the array
    // Constraints:
    // 1 <= nums.length <= 10^5
    // nums[i] is either 0 or 1

    // O(n^2) 불가
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
                continue;
            }
            count++;
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
