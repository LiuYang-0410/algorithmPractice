package leetcode;

/**
 * Created by liuyang on 16/8/7.
 */
public class LeetCode_29_DivideTwoIntegers {

    /**
     * 两数相除,不用乘\除\取余
     * 溢出,返回MAX_INT
     */
    public int divide(int dividend, int divisor) {//3ms
        long ans = 0;
        boolean flag = true;
        long dd = dividend, dv = divisor;
        if (dividend < 0){
            dd = -dd;
            flag = !flag;
        }
        if (divisor < 0){
            dv = -dv;
            flag = !flag;
        }
        long temp[] = new long[32];
        int curIndex = -1;
        for (long t_dv = dv; t_dv <= dd; t_dv <<= 1) {
            temp[++curIndex] = t_dv;
        }
        long max = (long) Math.pow(2,curIndex);
        while (curIndex >= 0){
            if (dd >= temp[curIndex]){
                ans += max;
                dd -= temp[curIndex];
            }
            max >>>= 1;
            curIndex --;
        }
        ans *= flag ? 1 : -1;
        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
    }

    public int divide2(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor== 1) return Integer.MAX_VALUE;
        if(dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if(dividend > 0) return -divideHelper(-dividend,divisor);
        else if(divisor > 0) return -divideHelper(dividend,-divisor);
        else return divideHelper(dividend, divisor);
    }

    private int divideHelper(int dividend, int divisor){
        // base case
        if(divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur-1);
        if(res > divisor) return 1 << cur-1;
        return (1 << cur-1)+divide(res, divisor);
    }

    public static void test(){
        LeetCode_29_DivideTwoIntegers divideTwoIntegers = new LeetCode_29_DivideTwoIntegers();
        System.out.println("**************************");
        System.out.println("372 / 51 = " + divideTwoIntegers.divide(372,51));
        System.out.println("-1 / -1 = " + divideTwoIntegers.divide(-1,-1));
        System.out.println("-1010369383 / -2147483648 = " + divideTwoIntegers.divide(-1010369383,-2147483648));
        System.out.println("-2147483648 / 1 = " + divideTwoIntegers.divide(-2147483648,1));
        System.out.println("-2147483648 / -1 = " + divideTwoIntegers.divide(-2147483648,-1));
        System.out.println("2147483647 / 1 = " + divideTwoIntegers.divide(2147483647, 1));
        System.out.println("2147483647 / 3 = " + divideTwoIntegers.divide(2147483647, 3));

        System.out.println("*************END*************");
    }

}
