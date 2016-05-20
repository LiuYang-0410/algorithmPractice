package leetcode;

/**
 * Created by liuyang on 16/5/14.
 */
public class LeetCode_9_PalindromeNumber {

    /**
     * 判断一个整数是否是回文
     * @param x 整数
     */
    public boolean isPalindrome(int x) {    //13ms,利用log求int的位数
        if (x < 0)
            return false;
        for (int base = (int) Math.pow(10,(int) Math.log10(x)); base > 1 ;  x = (x%base)/10,base/=100)
            if (x / base != x % 10)
                return false;
        return true;
    }

    public static void main(String[] args) {
        LeetCode_9_PalindromeNumber tool = new LeetCode_9_PalindromeNumber();
        System.out.println("1 是回文:\t"+tool.isPalindrome(1));
        System.out.println("10 是回文:\t"+tool.isPalindrome(10));
        System.out.println("34 是回文:\t"+tool.isPalindrome(34));
        System.out.println("99 是回文:\t"+tool.isPalindrome(99));
        System.out.println("1221 是回文:\t"+tool.isPalindrome(1221));
        System.out.println("1351 是回文:\t"+tool.isPalindrome(1351));
        System.out.println("12321 是回文:\t"+tool.isPalindrome(12321));
        System.out.println("22222 是回文:\t"+tool.isPalindrome(22222));
        System.out.println("1000000001 是回文:\t"+tool.isPalindrome(1000000001));
    }

}
