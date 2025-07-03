package reetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    // Constraints:
    // 1 <= n <= 2^31 - 1
    public boolean isHappy(int n) {
        double number = n;
        Set<Double> set = new HashSet<>();
        while (number != 1.0) {
            if (set.contains(number)) {
                return false;
            }
            set.add(number);
            double sum = (int) Math.pow(number % 10, 2);
            while (number >= 10) {
                number = (int) (number / 10);
                sum += (int) Math.pow(number % 10, 2);
            }
            number = sum;
        }
        return true;
    }
}
