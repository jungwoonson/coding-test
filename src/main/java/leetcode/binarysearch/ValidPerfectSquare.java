package leetcode.binarysearch;

public class ValidPerfectSquare {

    // Constraints:
    // 1 <= num <= 2^31 - 1
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = 46341;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }

        return false;
    }
}
