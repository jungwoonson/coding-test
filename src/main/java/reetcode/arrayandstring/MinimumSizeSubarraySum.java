package reetcode.arrayandstring;

public class MinimumSizeSubarraySum {
    // Constraints:
    // 1 <= target <= 10^9
    // 1 <= nums.length <= 10^5
    // 1 <= nums[i] <= 10^4
    public int minSubArrayLen(int target, int[] nums) {
        int[] sumArr = new int[nums.length + 1];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }

        int left = 0;
        int right = 1;
        int result = Integer.MAX_VALUE;
        while (left < sumArr.length) {
            while (right < sumArr.length - 1 && sumArr[right] - sumArr[left] < target) {
                right++;
            }
            if (sumArr[right] - sumArr[left] >= target) {
                int count = right - left;
                result = Math.min(result, count);
            }
            left++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // I don't need to calculate a prefix sum. you can do it like this.
    // This approach is called the sliding window technique.
    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];                 // 윈도우에 새 값 추가

            while (sum >= target) {             // 합이 target 이상이면
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];            // left를 한 칸 옮겨 윈도우 축소
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
