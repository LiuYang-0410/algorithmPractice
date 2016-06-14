package leetcode;

/**
 * Created by ly_anna on 2016/5/21.
 */
public class LeetCode_14_CommonPrefix {

    /**
     * 求出字符串数组的最长公共前缀
     * @param strs  字符串数组
     * @return  公共前缀
     */
    public String longestCommonPrefix(String[] strs) {  //3ms
        if (strs.length == 0)
            return "";
        int shortest = 0;
        for (int i = 1; i < strs.length; i++) //找出最短的字符串
            if (strs[i].length() < strs[shortest].length())
                shortest = i;
        int prefixEnd = strs[shortest].length();
        for (int i = 0; i < strs.length; i++)
            if (i != shortest){
                int tempEnd = 0;
                while (tempEnd < prefixEnd && strs[i].charAt(tempEnd) == strs[shortest].charAt(tempEnd))
                    tempEnd++;
                prefixEnd = tempEnd;
            }
        return strs[0].substring(0,prefixEnd);
    }

    public String longestCommonPrefix2(String[] strs){  //3ms
        if (strs.length == 0)
            return "";
        int prefixEnd = 0;
        while (prefixEnd < strs[0].length()){
            char ch = strs[0].charAt(prefixEnd);
            for (String str : strs)
                if (str.length() == prefixEnd || str.charAt(prefixEnd) != ch)
                    return str.substring(0,prefixEnd);
            prefixEnd++;
        }
        return strs[0].substring(0,prefixEnd);
    }

    public String longestCommonPrefix3(String[] strs){  //1ms
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int shortest = 0;
        for (int i = 1; i < strs.length; i++) //找出最短的字符串
            if (strs[i].length() < strs[shortest].length())
                shortest = i;
        StringBuffer out = new StringBuffer(strs[shortest]);
        for (String str : strs) {
            while (str.indexOf(out.toString()) != 0)
                out.deleteCharAt(out.length()-1);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        LeetCode_14_CommonPrefix commonPrefix = new LeetCode_14_CommonPrefix();
        {
            String input[] = {"acdvtbg","acdvbthbw","acdghtwb","acdv"};
            System.out.println(commonPrefix.longestCommonPrefix(input));
            System.out.println(commonPrefix.longestCommonPrefix2(input));
            System.out.println(commonPrefix.longestCommonPrefix3(input));
        }
        {
            String input[] = {};
            System.out.println(commonPrefix.longestCommonPrefix(input));
            System.out.println(commonPrefix.longestCommonPrefix2(input));
            System.out.println(commonPrefix.longestCommonPrefix3(input));
        }
        {
            String input[] = {"abd","","sscf"};
            System.out.println(commonPrefix.longestCommonPrefix(input));
            System.out.println(commonPrefix.longestCommonPrefix2(input));
            System.out.println(commonPrefix.longestCommonPrefix3(input));
        }
    }
}
