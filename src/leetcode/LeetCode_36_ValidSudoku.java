package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ly_anna on 2016/10/26.
 */
public class LeetCode_36_ValidSudoku {

    public static boolean isValidSudoku4(char[][] board){//32ms
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>(), col = new HashSet<>(),cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                int rowIndex = 3 * (i/3);//bravo
                int colIndex = 3 * (i%3);
                if (board[rowIndex+j/3][colIndex+j%3] != '.' && !cube.add(board[rowIndex+j/3][colIndex+j%3]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku3(char[][] board){//28ms
        for (int i = 0; i < 9; i++) {
            int row[] = new int[9], col[] = new int[9],cube[] = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    if (row[board[i][j]-'1'] == 1)
                        return false;
                    row[board[i][j]-'1']++;
                }
                if (board[j][i] != '.'){
                    if (col[board[j][i]-'1'] == 1)
                        return false;
                    col[board[j][i]-'1']++;
                }
                int rowIndex = 3 * (i/3);//bravo
                int colIndex = 3 * (i%3);
                if (board[rowIndex+j/3][colIndex+j%3] != '.'){
                    if (cube[board[rowIndex+j/3][colIndex+j%3]-'1'] == 1)
                        return false;
                    cube[board[rowIndex+j/3][colIndex+j%3]-'1']++;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board){//37ms
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                String s = "(" + board[i][j] + ")";
                if (!set.add(i+s) || !set.add(s+j) || !set.add(i/3 + s + j/3))
                    return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {//33ms
        for (int i = 0; i < 9; i++) {
            int row[] = new int[9], col[] = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    if (row[board[i][j]-'1'] == 1)
                        return false;
                    row[board[i][j]-'1']++;
                }
                if (board[j][i] != '.'){
                    if (col[board[j][i]-'1'] == 1)
                        return false;
                    col[board[j][i]-'1']++;
                }
                if ( i % 3 == 0 && j % 3 == 0){
                    int grid[] = new int[9];
                    for (int temp_i = i, temp_j = j, grid_i = 0; grid_i < 9; grid_i++) {
                        if (board[temp_i][temp_j] != '.'){
                            if (grid[board[temp_i][temp_j]-'1'] == 1)
                                return false;
                            grid[board[temp_i][temp_j]-'1'] = 1;
                        }
                        if (grid_i % 3 == 2){
                            temp_i++;
                            temp_j = j;
                        }else
                            temp_j++;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {{'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku2(board));
        System.out.println(isValidSudoku3(board));
        System.out.println(isValidSudoku4(board));
    }
}
