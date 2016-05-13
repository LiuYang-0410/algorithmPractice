package leetcode;

/**
 * Created by liuyang on 16/5/13.
 */
public class LeetCode_7_ReverseInteger {

    /**
     * 将整数按位反转
     * @param x 整数
     * @return  反转之后的整数,如果反转后的结果查过int可表示的范围,返回0
     */
    public int reverse(int x) { //3ms
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int)res;
    }

    public static void main(String[] args) {
        LeetCode_7_ReverseInteger tool = new LeetCode_7_ReverseInteger();
        System.out.println("123 => "+tool.reverse(123));
        System.out.println("-123 => "+tool.reverse(-123));
        System.out.println("0 => "+tool.reverse(0));
        System.out.println("1 => "+tool.reverse(1));
        System.out.println("-1 => "+tool.reverse(-1));
        System.out.println(Integer.MAX_VALUE+" => "+tool.reverse(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE+" => "+tool.reverse(Integer.MIN_VALUE));
    }
}
