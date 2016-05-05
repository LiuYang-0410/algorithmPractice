package 剑指offer;

/**
 * Created by liuyang on 16/4/25.
 */
public class StringToInt49 {

    /**
     * 把字符串转为整数
     * @param string    给定字符串
     * @return  对应整数,非法输入或超过范围输出null
     */
    public Integer convertStrToInt(String string){
        if (string == null || string.length() <= 0
                || string.startsWith("-") && string.length() == 1)
            return null;
        boolean isPositive = true;
        int numberBegin = 0;
        if (string.startsWith("-")){
            isPositive = false;
            numberBegin++;
        }
        long result = 0;
        while (numberBegin < string.length()){
            result = result * 10 + string.charAt(numberBegin++) - '0';
            if (isPositive && result > Integer.MAX_VALUE
                    || !isPositive && result - 1 > Integer.MAX_VALUE)
                return null;
        }
        if (!isPositive)
            result = -result;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        StringToInt49 tool = new StringToInt49();
        System.out.println("   对应的整数:\t"+tool.convertStrToInt(""));
        System.out.println("123对应的整数:\t"+tool.convertStrToInt("123"));
        System.out.println("-123对应的整数:\t"+tool.convertStrToInt("-123"));
        System.out.println("2147483647对应的整数:\t"+tool.convertStrToInt("2147483647"));
        System.out.println("-2147483648对应的整数:\t"+tool.convertStrToInt("-2147483648"));
        System.out.println("2147483648对应的整数:\t"+tool.convertStrToInt("2147483648"));
        System.out.println("-2147483649对应的整数:\t"+tool.convertStrToInt("-2147483649"));
    }

}
