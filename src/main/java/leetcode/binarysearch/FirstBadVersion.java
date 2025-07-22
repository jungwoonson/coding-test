package leetcode.binarysearch;

import java.util.Random;

public class FirstBadVersion {

    // Constraints:
    // 1 <= bad <= n <= 2^31 - 1
    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        return isBadVersion(left) ? left : left + 1;
    }

    boolean isBadVersion(int version) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
