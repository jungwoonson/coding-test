package reetcode.array;

public class SortArrayByParity {
    // Constraints:
    // 1 <= nums.length <= 5000
    // 0 <= nums[i] <= 5000
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[left++] = num;
                continue;
            }
            result[right--] = num;
        }
        return result;
    }
}
