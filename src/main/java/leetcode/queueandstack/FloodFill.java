package leetcode.queueandstack;

class FloodFill {

    // Constraints:
    // m == image.length
    // n == image[i].length
    // 1 <= m, n <= 50
    // 0 <= image[i][j], color < 2^16
    // 0 <= sr < m
    // 0 <= sc < n
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return paint(image, sr, sc, color, image[sr][sc]);
    }

    private int[][] paint(int[][] image, int sr, int sc, int color, int target) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != target) {
            return image;
        }

        image[sr][sc] = color;
        paint(image, sr - 1, sc, color, target);
        paint(image, sr + 1, sc, color, target);
        paint(image, sr, sc - 1, color, target);
        paint(image, sr, sc + 1, color, target);

        return image;
    }
}
