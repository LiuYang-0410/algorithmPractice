package leetcode;

/**
 * Created by ly_anna on 2016/6/14.
 */
public class LeetCode_28_strStr {

    /**
     * 找到haystack中needle的位置，如无则为-1
     */
    public int strStr(String haystack, String needle) {//1ms
        for (int i = 0; i <= haystack.length() - needle.length(); i++)
            if (haystack.substring(i,i+needle.length()).equals(needle))
                return i;
        return -1;
    }
    public int strStr2(String haystack, String needle) {//0ms
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        LeetCode_28_strStr strStr = new LeetCode_28_strStr();
        System.out.println(strStr.strStr("",""));
        System.out.println(strStr.strStr2("",""));
        System.out.println(strStr.strStr("asdgf","sd"));
        System.out.println(strStr.strStr2("asdgf","sd"));
        System.out.println(strStr.strStr("asdgf","sde"));
        System.out.println(strStr.strStr2("asdgf","sde"));
        System.out.println(strStr.strStr("mississippi","pi"));
        System.out.println(strStr.strStr2("mississippi","pi"));
    }
}
