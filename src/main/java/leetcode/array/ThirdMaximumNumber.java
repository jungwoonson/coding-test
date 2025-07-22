package leetcode.array;

public class ThirdMaximumNumber {
    // Constraints:
    // 1 <= nums.length <= 10^4
    // -2^31 <= nums[i] <= 2^31 - 1

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {

            if (first == num || second == num || third == num) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
                continue;
            }
            if (num > second) {
                third = second;
                second = num;
                continue;
            }
            if (num > third) {
                third = num;
            }
        }

        return third > Long.MIN_VALUE ? (int) third : (int) first;
    }
}
