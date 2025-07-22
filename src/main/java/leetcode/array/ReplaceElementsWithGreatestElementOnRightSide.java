package leetcode.array;

public class ReplaceElementsWithGreatestElementOnRightSide {
    // Constraints:
    // 1 <= arr.length <= 10^4
    // 1 <= arr[i] <= 10^5
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }
}
