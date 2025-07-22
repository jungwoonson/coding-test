package leetcode.queueandstack;

class NumberOfIslands2 {

    // Constraints:
    // m == grid.length
    // n == grid[i].length
    // 1 <= m, n <= 300
    // grid[i][j] is '0' or '1'.

    private int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                count++;
                recursion2(grid, i, j);
            }
        }

        return count;
    }

    private void recursion(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                recursion(grid, newRow, newCol);
            }
        }
    }

    // 반복문을 사용해서 row col 값을 변경 시키는 것 보다 아래처럼 수동으로 4번 돌리는 것이 더 빠르다
    private void recursion2(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        recursion2(grid, row, col + 1);
        recursion2(grid, row + 1, col);
        recursion2(grid, row, col - 1);
        recursion2(grid, row - 1, col);
    }
}
