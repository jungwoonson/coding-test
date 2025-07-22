package leetcode.array;

public class CheckIfNAndItsDoubleExist {
    // Constraints:
    // 2 <= arr.length <= 500
    //-10^3 <= arr[i] <= 10^3

    // length 최대가 500이라 O(n^2)으로 풀어도 상관은 없음
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == arr[j] * 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
