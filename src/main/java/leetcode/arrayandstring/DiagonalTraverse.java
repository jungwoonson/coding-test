package leetcode.arrayandstring;

public class DiagonalTraverse {
    // Constraints:
    // m == mat.length
    // n == mat[i].length
    // 1 <= m, n <= 10^4
    // 1 <= m * n <= 10^4
    // -10^5 <= mat[i][j] <= 10^5

    // (0,0) | (0,1) (1,0) | (2,0) (1,1) (0,2) | (1,2) (2,1) | (2,2)
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int idx = 0;

        for (int d = 0; d < m + n - 1; d++) {
            int r, c;
            if (d % 2 == 0) {
                r = d < m ? d : m - 1;
                c = d - r;
                while (r >= 0 && c < n) {
                    result[idx++] = mat[r--][c++];
                }
            } else {
                c = d < n ? d : n - 1;
                r = d - c;
                while (c >= 0 && r < m) {
                    result[idx++] = mat[r++][c--];
                }
            }
        }

        return result;
    }
}
