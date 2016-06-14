package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly_anna on 2016/5/31.
 */
public class LeetCode_22_GenerateParentheses {

    List<String> out;
    char template[];

    /**
     * 产生n对括号所有的组合
     */
    public List<String> generateParenthesis(int n) {    //1ms
        template = new char[2*n];
        out = new ArrayList<>();
        helper(0,0,n);
        return out;
    }

    private void helper(int index, int leftCount,int n){
        if (index == template.length-1){
            template[index] = ')';
            out.add(new String(template));
            return;
        }
        if (leftCount < n){
            template[index] = '(';
            helper(index+1,leftCount+1,n);
        }
        if (2*leftCount > index){
            template[index] = ')';
            helper(index+1,leftCount,n);
        }
    }

    public static void main(String[] args) {
        LeetCode_22_GenerateParentheses generateParentheses = new LeetCode_22_GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(1));
        System.out.println(generateParentheses.generateParenthesis(2));
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
