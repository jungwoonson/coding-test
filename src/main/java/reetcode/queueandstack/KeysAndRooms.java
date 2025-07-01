package reetcode.queueandstack;

import java.util.*;

class KeysAndRooms {

    // Constraints:
    // n == rooms.length
    // 2 <= n <= 1000
    // 0 <= rooms[i].length <= 1000
    // 1 <= sum(rooms[i].length) <= 3000
    // 0 <= rooms[i][j] < n
    // All the values of rooms[i] are unique.
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> keys = rooms.get(current);
            for (int key : keys) {
                if (visited.contains(key)) {
                    continue;
                }
                visited.add(key);
                queue.add(key);
            }
        }

        return visited.size() == rooms.size();
    }
}
