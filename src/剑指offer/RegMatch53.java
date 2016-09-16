package 剑指offer;

/**
 * Created by liuyang on 16/4/25.
 */
public class RegMatch53 {

    /**
     * 正则表达式匹配. 或 *
     * @param original   原字符串
     * @param reg   正则表达式
     * @return  是否匹配
     */
    public boolean match(String original, String reg){
        if (original == null || original.length() <= 0 || reg == null || reg.length() <= 0)
            return true;
        return helper(original.toCharArray(),0,reg.toCharArray(),0);
    }

    private boolean helper(char[] original,int strIndex, char[] reg,int regIndex){
        if (strIndex == original.length && regIndex == reg.length)
            return true;    //同时走到字符串结尾
        if (regIndex == reg.length)
            return false;   //原字符串还没结束,正则已结束
        if (strIndex == original.length){   //原字符串已经结束,之后的正则只有ch*形式可以匹配
            if (regIndex < reg.length-1 && reg[regIndex] == '*')
                return helper(original,strIndex,reg,regIndex+2);    //*出现0次
            return false;
        }
        if (reg[regIndex] == '.')
            return helper(original,strIndex+1,reg,regIndex+1);
        if (regIndex == reg.length-1 || reg[regIndex+1] != '*'){
            if (reg[regIndex] != original[strIndex])
                return false;
            return helper(original,strIndex+1,reg,regIndex+1);
        }
        if (reg[regIndex] == original[strIndex] && helper(original,strIndex+1,reg,regIndex))
            return true;    //* 出现任意次 
        return helper(original,strIndex,reg,regIndex+2);    //*出现0次
    }

    public static void main(String[] args) {
        RegMatch53 tool = new RegMatch53();
        System.out.println("aaa和a.a是否匹配:\t"+tool.match("aaa","a.a"));
        System.out.println("aaa和ab*ac*a是否匹配:\t"+tool.match("aaa","ab*ac*a"));
        System.out.println("aaa和aa.a是否匹配:\t"+tool.match("aaa","aa.a"));
        System.out.println("aaa和ab*a是否匹配:\t"+tool.match("aaa","ab*a"));
    }
}
