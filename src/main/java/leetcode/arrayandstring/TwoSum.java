package leetcode.arrayandstring;

public class TwoSum {
    // Constraints:
    // 2 <= numbers.length <= 3 * 10^4
    // -1000 <= numbers[i] <= 1000
    // numbers is sorted in non-decreasing order.
    // -1000 <= target <= 1000
    // The tests are generated such that there is exactly one solution.
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
    }

    // Since the array is already sorted, it can be solved using the two-pointer technique.
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
                continue;
            }
            right--;
        }

        return new int[0];
    }
}
