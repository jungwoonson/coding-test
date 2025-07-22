package leetcode.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // Constraints:
    // 1 <= numRows <= 30
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> beforeRow = result.get(i - 1);
                row.add(beforeRow.get(j - 1) + beforeRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
