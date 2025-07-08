package reetcode.hashtable;

public class ValidSudoku {

    // Constraints:
    // board.length == 9
    // board[i].length == 9
    // board[i][j] is a digit 1-9 or '.'.
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                count[board[i][j] - '1']++;
                if (count[board[i][j] - '1'] > 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                count[board[j][i] - '1']++;
                if (count[board[j][i] - '1'] > 1) {
                    return false;
                }
            }
        }

        int row = 0;
        int col = 0;
        while (col < 9) {
            int[] count = new int[9];
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    count[board[i][j] - '1']++;
                    if (count[board[i][j] - '1'] > 1) {
                        return false;
                    }
                }
            }
            row += 3;
            if (row >= 9) {
                row = 0;
                col += 3;
            }
        }

        return true;
    }
}
