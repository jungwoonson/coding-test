package leetcode.array;

public class MergeSortedArray {
    // Follow up: Can you come up with an algorithm that runs in O(m + n) time?
    // 이미 정렬되어 있기 때문에 투 포인터를 사용해서 뒤에서부터 num1과 num2를 비교하며 채운다
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (index >= 0) {
            if (n < 0) {
                return;
            }
            if (m < 0 || nums1[m] <= nums2[n]) {
                nums1[index--] = nums2[n--];
                continue;
            }
            nums1[index--] = nums1[m--];
        }
    }
}
