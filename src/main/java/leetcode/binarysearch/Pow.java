package leetcode.binarysearch;

public class Pow {

    // Constraints:
    // -100.0 < x < 100.0
    // -2^31 <= n <= 2^31-1
    // n is an integer.
    // Either x is not zero or n > 0.
    // -10^4 <= xn <= 10^4
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}
