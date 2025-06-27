package reetcode.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {

    // Constraints:
    // m == grid.length
    // n == grid[i].length
    // 1 <= m, n <= 300
    // grid[i][j] is '0' or '1'.
    public int numIslands(char[][] grid) {
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        int count = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] indexes = queue.poll();
                        for (int[] direction : directions) {
                            int y = indexes[0] + direction[0];
                            int x = indexes[1] + direction[1];
                            if (y >= 0 && x >= 0 && y < grid.length && x < grid[y].length
                                    && grid[y][x] == '1') {
                                queue.add(new int[]{y, x});
                                grid[y][x] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
