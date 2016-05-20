package leetcode;

/**
 * Created by liuyang on 16/5/14.
 */
public class LeetCode_10_RegularMatch {

    /**
     * 正则匹配
     * @param s 给定字符串
     * @param p 正则表达式,.代表任意单个字符,*代表之前的字符出现0次或多次
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {    //26ms
        return helper(s.toCharArray(),p.toCharArray(),0,0);
    }

    private boolean helper(char s[], char p[], int sIndex, int pIndex){
        if (pIndex == p.length)//字符串和匹配同时结束true,匹配先结束false
            return sIndex == s.length ? true : false;
        int diff = 1;
        if (pIndex < p.length-1 && p[pIndex+1] == '*'){//*匹配
            if (helper(s,p,sIndex,pIndex+2))    //字符已结束或匹配0个字符成功
                return true;
            diff = 0;
        }
        if (sIndex < s.length && (p[pIndex] == '.' || s[sIndex] == p[pIndex])) //普通匹配
            return helper(s,p,sIndex+1,pIndex+diff);
        return false;
    }

    public boolean isMatch2(String s, String p) {    //26ms
        return helper(s.toCharArray(),p.toCharArray(),0,0);
    }

    public static void main(String[] args) {
        LeetCode_10_RegularMatch regularMatch = new LeetCode_10_RegularMatch();
        System.out.println("FALSE:\t"+regularMatch.isMatch("aa","a"));
        System.out.println("TRUE :\t"+regularMatch.isMatch("aa","aa"));
        System.out.println("FALSE:\t"+regularMatch.isMatch("aaa","aa"));
        System.out.println("TRUE :\t"+regularMatch.isMatch("aaa","a*"));
        System.out.println("TRUE :\t"+regularMatch.isMatch("aaa",".*"));
        System.out.println("FALSE:\t"+regularMatch.isMatch("ab",".*c"));
        System.out.println("TRUE :\t"+regularMatch.isMatch("aab","c*a*b"));
        System.out.println("FALSE:\t"+regularMatch.isMatch("aab","aabcdf"));
        System.out.println("TRUE :\t"+regularMatch.isMatch("aab","aab.*"));
        System.out.println("FALSE:\t"+regularMatch.isMatch("","..*"));
    }
}
