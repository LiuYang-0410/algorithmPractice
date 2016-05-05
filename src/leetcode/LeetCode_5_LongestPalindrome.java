package leetcode;

/**
 * Created by liuyang on 16/5/5.
 */
public class LeetCode_5_LongestPalindrome {

    /**
     * 最长回文子串
     * @param s 给定字符串,长度不超过1000,存在唯一最长回文子串
     * @return  最长回文子串
     */
    public String longestPalindrome(String s) { //20ms
        int begin = 0, end = 0, maxLen = 1;
        for (int i = 0; i < s.length()-1; i++) {
            int len1 = 0, len2 = 0;
            if (i > 0 && s.charAt(i-1) == s.charAt(i+1))
                len1 = checkPalindrome(s,i-1,i+1);
            if (s.charAt(i) == s.charAt(i+1))
                len2 = checkPalindrome(s,i,i+1);
            if (len1 > len2 && len1 > maxLen){
                maxLen = len1;
                begin = i - len1/2;
                end = i + len1/2;
            }else if (len2 > len1 && len2 > maxLen){
                maxLen = len2;
                begin = i - len2/2+1;
                end = i + len2/2;
            }
        }
        return s.substring(begin,end+1);
    }

    private int checkPalindrome(String s, int left,int right){
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left-1;
    }

    public static void main(String[] args) {
        LeetCode_5_LongestPalindrome tool = new LeetCode_5_LongestPalindrome();
        System.out.println(tool.longestPalindrome("1233454330"));
        System.out.println(tool.longestPalindrome("ccc"));
        System.out.println(tool.longestPalindrome("aaaa"));
        System.out.println(tool.longestPalindrome("aaaaa"));
        System.out.println(tool.longestPalindrome("iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz"));
    }
}
