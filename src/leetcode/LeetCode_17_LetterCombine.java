package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly_anna on 2016/5/29.
 */
public class LeetCode_17_LetterCombine {

    static char chs[][] = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    List<String> out;
    char myCh[][];
    /**
     * 给的数字组成的字符串，给出拨号键盘上所有可能的英文字母的组合
     * @param digits    数字组成的字符串
     * @return  所有英文字母的组合
     */
    public List<String> letterCombinations(String digits) { //1ms
        out = new ArrayList<>();
        if (digits.isEmpty())
            return out;
        myCh = new char[digits.length()][4];
        for (int i = 0; i < digits.length(); i++)
            myCh[i] = chs[digits.charAt(i)-'2'];
        char template[] = new char[digits.length()];
        helper(0,template);
        return out;
    }

    private void helper(int curIndex,char template[]){
        if (curIndex == myCh.length){
            out.add(new String(template));
            return;
        }
        for (int i = 0; i < myCh[curIndex].length; i++) {
            template[curIndex] = myCh[curIndex][i];
            helper(curIndex+1,template);
        }
    }
    public static void main(String[] args) {
        LeetCode_17_LetterCombine letterCombine = new LeetCode_17_LetterCombine();
        System.out.println(letterCombine.letterCombinations("23"));
        /*List<String> out = letterCombine.letterCombinations("23");
        for (String str : out) {
            System.out.println(str);
        }*/
    }
}
