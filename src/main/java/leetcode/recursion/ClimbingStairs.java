package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    // 1 <= n <= 45
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
