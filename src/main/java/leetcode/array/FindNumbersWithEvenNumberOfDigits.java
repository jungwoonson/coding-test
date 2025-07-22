package leetcode.array;

public class FindNumbersWithEvenNumberOfDigits {
    // Given an array nums of integers, return how many of them contain an even number of digits.
    // Constraints:
    // 1 <= nums.length <= 500
    // 1 <= nums[i] <= 10^5

    // O(n^2) 불가
    // 1 홀수, 10 짝수, 100 홀수, 1000 짝수
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int count = 0;
            while (num / 10 > 0) {
                count++;
                num /= 10;
            }
            if (count % 2 == 1) {
                result++;
            }
        }
        return result;
    }

    // 시간 공간 둘 다 아래 코드가 더 좋긴하다.....
    public int findNumbers2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num >= 100000) {
                result++;
            }
            if (num < 10000 && num >= 1000) {
                result++;
            }
            if (num < 100 && num >= 10) {
                result++;
            }
        }
        return result;
    }
}
