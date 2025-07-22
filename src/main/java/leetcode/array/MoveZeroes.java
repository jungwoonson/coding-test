package leetcode.array;

public class MoveZeroes {
    // Constraints:
    // 1 <= nums.length <= 10^4
    // -2^31 <= nums[i] <= 2^31 - 1
    public void moveZeroes(int[] nums) {
        int target = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                continue;
            }
            if (target < i) {
                target = i;
            }
            while (target < nums.length - 1 && nums[target] == 0) {
                target++;
            }
            nums[i] = nums[target];
            nums[target] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
