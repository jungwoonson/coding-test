package leetcode.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // Constraints:
    // m == matrix.length
    // n == matrix[i].length
    // 1 <= m, n <= 10
    // -100 <= matrix[i][j] <= 100
    public List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;

        List<Integer> result = new ArrayList<>(w * h);
        Point point = new Point(matrix[0].length - 1, matrix.length - 1);
        for (int i = 0; i < w * h; i++) {
            result.add(matrix[point.getY()][point.getX()]);
            point.move();
        }

        return result;
    }

    private class Point {
        private int x = 0;
        private int y = 0;
        private int direction = 0; // 0 right, 1 down, 2 left, 3 up
        private int minX = 0;
        private int minY = 0;
        private int maxX;
        private int maxY;

        public Point(int maxX, int maxY) {
            this.maxX = maxX;
            this.maxY = maxY;
            if (maxX == 0) {
                direction = 1;
            }
        }

        public void move() {
            switch (direction) {
                case 0:
                    right();
                    break;
                case 1:
                    down();
                    break;
                case 2:
                    left();
                    break;
                case 3:
                    up();
            }
        }

        private void up() {
            y--;
            if (y == minY) {
                changeDirection();
                minX++;
            }
        }

        private void down() {
            y++;
            if (y == maxY) {
                changeDirection();
                maxX--;
            }
        }

        private void left() {
            x--;
            if (x == minX) {
                changeDirection();
                maxY--;
            }
        }

        private void right() {
            x++;
            if (x == maxX) {
                changeDirection();
                minY++;
            }
        }

        private void changeDirection() {
            direction = (direction + 1) % 4;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
