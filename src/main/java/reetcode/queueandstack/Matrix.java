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
}
