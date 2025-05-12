package reetcode.array;

import java.util.Arrays;

public class SquaresOfASortedArray {
    // Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order
    // 1 <= nums.length <= 10^4
    // -10^4 <= nums[i] <= 10^4
    // nums is sorted in non-decreasing order.

    // 투포인터를 사용하여 O(n)으로 해결
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare < rightSquare) {
                result[index--] = rightSquare;
                right--;
                continue;
            }
            result[index--] = leftSquare;
            left++;
        }
        return result;
    }

    // Arrays.sort() 를 사용하면 O(n log n)
    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
