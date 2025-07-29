package leetcode.binarysearch;

public class MedianOfTwoSortedArrays {

    // Constraints:
    // nums1.length == m
    // nums2.length == n
    // 0 <= m <= 1000
    // 0 <= n <= 1000
    // 1 <= m + n <= 2000
    // -10^6 <= nums1[i], nums2[i] <= 10^6
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;
        while (left <= right) {
            int i = left + (right - left) / 2; // nums1에서 자르는 위치
            int j = (m + n + 1) / 2 - i; // nums2에서 자르는 위치

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 올바르게 나눠졌는지 확인
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) { // 짝수
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
                // 홀수
                return Math.max(maxLeft1, maxLeft2);
            }

            if (maxLeft1 > minRight2) {
                right = i - 1; // 왼쪽을 줄여야 한다
                continue;
            }
            left = i + 1; // 오른쪽을 늘려야 한다
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }
}
