package leetcode;

/**
 * Created by liuyang on 16/5/14.
 */
public class LeetCode_8_ATOI {

    /**
     * 实现字符串转整数
     * @param string 字符串
     * @return 对应整数
     */
    public int myAtoi(String string){   //4ms
        long result = 0;
        boolean isPositive = true,hasSymbol = false;
        for (char ch : string.trim().toCharArray()) {
            if (hasSymbol && (ch == '+' || ch == '-'))
                break;
            if (ch == '+')
                hasSymbol = true;
            else if (ch == '-'){
                hasSymbol = true;
                isPositive = false;
            }else if (ch >= '0' && ch <= '9'){
                result = result * 10 + ch - '0';
                if (isPositive && result > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (!isPositive && result - 1 > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
            }else
                break;
        }
        return isPositive ? (int)result : (int)-result;
    }

    public static void main(String[] args) {
        LeetCode_8_ATOI atoi = new LeetCode_8_ATOI();
        System.out.println(atoi.myAtoi(""));
        System.out.println(atoi.myAtoi("+"));
        System.out.println(atoi.myAtoi("-"));
        System.out.println(atoi.myAtoi("3.5"));
        System.out.println(atoi.myAtoi("   010"));
        System.out.println(atoi.myAtoi("   -012ad23"));
        System.out.println(atoi.myAtoi("2147483647"));
        System.out.println(atoi.myAtoi("2147483649"));
        System.out.println(atoi.myAtoi("-2147483648"));
        System.out.println(atoi.myAtoi("-2147483649"));
    }

}
