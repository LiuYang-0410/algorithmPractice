package leetcode;

/**
 * Created by ly_anna on 2016/10/26.
 */
public class LeetCode_36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int temp[] = new int[9];
            for (char ch : board[i]) {
                if (ch == '.')
                    continue;
                if (temp[ch-'1'] == 1)
                    return false;
                temp[ch-'1']++;
            }
        }
        for (int col = 0; col < 9; col++) {
            int temp[] = new int[9];
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (temp[ch-'1'] == 1)
                    return false;
                temp[ch-'1']++;
            }
        }

    }
}
