package 剑指offer;

/**
 * Created by ly_anna on 2016/9/12.
 */
public class S_66_PathInMatrix {

    char[][] matrix;
    String path;
    boolean[][] flag;

    public S_66_PathInMatrix(char[][] matrix, String path) {
        this.path = path;
        this.matrix = matrix;
        flag = new boolean[matrix.length][matrix[0].length];
    }

    public boolean findPath(){
        //return helper(0,0,0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (helper(i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int index){
        if (index == path.length())
            return true;
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length)
            return false;
        if (flag[i][j] == true)
            return false;
        char target = path.charAt(index);
        char cur = matrix[i][j];
        if (cur != target)
            return false;
        if (helper( i , j + 1, index +1))   //right
            return true;
        else if (helper(i+1, j, index+1))   //down
            return true;
        else if (helper(i, j -1, index + 1))    //left
            return true;
        else if (helper(i-1,j,index+1)) //up
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        {
            S_66_PathInMatrix path = new S_66_PathInMatrix(matrix,"bcced");
            System.out.println(path.findPath());
        }
        {
            S_66_PathInMatrix path = new S_66_PathInMatrix(matrix,"abcd");
            System.out.println(path.findPath());
        }
    }
}
