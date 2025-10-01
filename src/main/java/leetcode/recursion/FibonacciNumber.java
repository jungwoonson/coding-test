package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    // 0 <= n <= 30
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 1) {
            return n;
        }
        map.put(n, fib(n - 1) + fib(n - 2));

        return fib(n - 1) + fib(n - 2);
    }
}
