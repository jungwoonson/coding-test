package reetcode.array;

public class HeightChecker {
    // Constraints:
    // 1 <= heights.length <= 100
    // 1 <= heights[i] <= 100
    public int heightChecker(int[] heights) {
        int[] counts = new int[101];
        for (int height : heights) {
            counts[height]++;
        }

        int result = 0;
        int i = 0;
        int j = 1;
        while (i < heights.length) {
            while (counts[j] > 0) {
                if (heights[i++] != j) {
                    result++;
                }
                counts[j]--;
            }
            j++;
        }

        return result;
    }
}
