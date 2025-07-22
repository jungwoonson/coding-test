package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    // Constraints:
    // 1 <= k <= arr.length
    // 1 <= arr.length <= 10^4
    // arr is sorted in ascending order.
    // -10^4 <= arr[i], x <= 10^4

    // 1,2,3,4,5  4  3
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        int mid = 0;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
                continue;
            }
            high = mid;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

