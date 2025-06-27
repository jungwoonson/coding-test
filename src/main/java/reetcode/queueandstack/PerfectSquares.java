package reetcode.queueandstack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PerfectSquares {

    // Constraints:
    // 1 <= n <= 10^4
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        squares.sort(Comparator.reverseOrder());

        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int origin = queue.poll();
                for (Integer square : squares) {
                    int result = origin - square;
                    if (result == 0) {
                        return count;
                    }
                    if (result > 0) {
                        queue.add(result);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
