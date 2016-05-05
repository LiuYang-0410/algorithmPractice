package 剑指offer;

/**
 * Created by liuyang on 16/4/25.
 */
public class IsNumber54 {

    /**
     * 判断字符串是不是一个数字
     * @param string    给定字符串
     * @return  是否数字
     */
    public boolean isNumber(String string){
        if (string == null || string.length() <= 0)
            return false;
        boolean hasSymbol = false,hasDot = false,hasNum = false;
        boolean hasE = false,hasESymbol = false,hasENum = false;
        for (char ch : string.toCharArray()) {
            switch (ch){
                case '.':   //只能有一个小数点,且e之后不能有小数点
                    if (hasE || hasDot)   return false;
                    hasDot = true;
                    break;
                case '+':
                case '-':   //符号位只能有一个,e之后可以再有一个
                    if (!hasE && hasSymbol || hasE && hasESymbol) return false;
                    if (hasE)
                        hasESymbol = true;
                    else
                        hasSymbol = true;
                    break;
                case 'e':
                case 'E':   //只能有一个符号位
                    if (hasE)
                        return false;
                    hasE = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (!hasE)
                        hasNum = true;
                    else if (!hasNum)   //e之前必须有数字
                        return false;
                    else
                        hasENum = true; //e之后必须有数字
                    break;
                default:    //以上之外的符号都为非法字符
                    return false;
            }
        }
        if (hasNum && (!hasE || hasE && hasENum))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        IsNumber54 tool = new IsNumber54();
        System.out.println("+100是否是数字:\t"+tool.isNumber("+100"));
        System.out.println("5e2是否是数字:\t"+tool.isNumber("5e2"));
        System.out.println("-123是否是数字:\t"+tool.isNumber("-123"));
        System.out.println("3.1416是否是数字:\t"+tool.isNumber("3.1416"));
        System.out.println("-1E-16是否是数字:\t"+tool.isNumber("-1E-16"));
        System.out.println("12e是否是数字:\t"+tool.isNumber("12e"));
        System.out.println("1a3.14是否是数字:\t"+tool.isNumber("1a3.14"));
        System.out.println("1.2.3是否是数字:\t"+tool.isNumber("1.2.3"));
        System.out.println("+-5是否是数字:\t"+tool.isNumber("+-5"));
        System.out.println("12e+5.4是否是数字:\t"+tool.isNumber("12e+5.4"));
    }
}
