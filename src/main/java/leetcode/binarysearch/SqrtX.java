package leetcode.binarysearch;

public class SqrtX {

    // Constraints:
    // 0 <= x <= 2^31 - 1
    public int mySqrt(int x) {
        long low = 0;
        long high = 46341;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long pow1 = mid * mid;
            long pow2 = (mid + 1) * (mid + 1);
            if (pow1 <= x && x < pow2) {
                return (int) mid;
            }
            if (pow1 > x) {
                high = mid - 1;
                continue;
            }
            if (pow2 <= x) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
