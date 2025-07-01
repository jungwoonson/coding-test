package reetcode.queueandstack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Matrix {

    // Constraints:
    // m == mat.length
    // n == mat[i].length
    // 1 <= m, n <= 10^4
    // 1 <= m * n <= 10^4
    // mat[i][j] is either 0 or 1.
    // There is at least one 0 in mat.
    public int[][] updateMatrix(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                Queue<Location> queue = new LinkedList<>();
                Set<Location> visited = new HashSet<>();
                Location lo = new Location(i, j);
                queue.add(lo);
                visited.add(lo);
                int level = 0;
                while (!queue.isEmpty()) {
                    int repeat = queue.size();
                    for (int k = 0; k < repeat; k++) {
                        Location location = queue.poll();
                        if (mat[location.row][location.col] == 0) {
                            mat[i][j] = level;
                            queue.clear();
                            break;
                        }
                        Location location1 = new Location(location.row + 1, location.col);
                        if (location.row + 1 < mat.length && !visited.contains(location1)) {
                            visited.add(location1);
                            queue.add(location1);
                        }
                        Location location2 = new Location(location.row - 1, location.col);
                        if (location.row - 1 >= 0 && !visited.contains(location2)) {
                            visited.add(location2);
                            queue.add(location2);
                        }
                        Location location3 = new Location(location.row, location.col + 1);
                        if (location.col + 1 < mat[i].length && !visited.contains(location3)) {
                            visited.add(location3);
                            queue.add(location3);
                        }
                        Location location4 = new Location(location.row, location.col - 1);
                        if (location.col - 1 >= 0 && !visited.contains(location4)) {
                            visited.add(location4);
                            queue.add(location4);
                        }
                    }
                    level++;
                }
            }
        }

        return mat;
    }

    class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Location location = (Location) o;
            return row == location.row && col == location.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    // 위 방법은 시간 복잡도가 O((m * n)^2) 라서 사실상 정답이라 보기 힘들다
    // 아래처럼 Multi-Source BFS 를 사용해서 풀어야하는 문제이다
    public int[][] updateMatrixOfGPT(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 1. 모든 0을 큐에 넣고, 1은 -1로 초기화 (아직 방문 안한 셀 표시)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // 2. BFS 실행
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] != -1) {
                    continue;
                }
                mat[r][c] = mat[row][col] + 1;
                queue.add(new int[]{r, c});
            }
        }

        return mat;
    }
}
