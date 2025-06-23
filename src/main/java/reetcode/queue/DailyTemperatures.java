package reetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

class DailyTemperatures {

    // Constraints:
    // 1 <= temperatures.length <= 10^5
    // 30 <= temperatures[i] <= 100
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }

        return result;
    }
}
