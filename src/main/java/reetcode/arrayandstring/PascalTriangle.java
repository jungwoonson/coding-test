package reetcode.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // Constraints:
    // 0 <= rowIndex <= 33
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>(rowIndex);
        result.add(List.of(1));
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> beforeRow = result.get(i - 1);
                row.add(beforeRow.get(j - 1) + beforeRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result.get(rowIndex);
    }

    // This is a more efficient way to calculate the row of Pascal's Triangle.
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ll = new ArrayList<>();
        long ans = 1;
        ll.add((int) ans);
        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1);
            ans = ans / i;
            ll.add((int) ans);
        }
        return ll;
    }
}
