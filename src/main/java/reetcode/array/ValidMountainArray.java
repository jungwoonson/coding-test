package reetcode.array;

public class ValidMountainArray {
    // Constraints:
    // 1 <= arr.length <= 10^4
    // 0 <= arr[i] <= 10^4

    public boolean validMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr.length < 3 || arr[left] >= arr[left + 1] || arr[right - 1] <= arr[right]) {
            return false;
        }
        while (arr[left] < arr[left + 1]) {
            left++;
        }
        while (arr[right] < arr[right - 1]) {
            right--;
        }
        return left == right;
    }
}
