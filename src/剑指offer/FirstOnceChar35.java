package 剑指offer;

/**
 * Created by liuyang on 16/4/22.
 */
public class FirstOnceChar35 {


    /**
     * 输出第一个只出现一次的字符
     * @param str   输入字符串
     * @return  只出现一次的字符
     */
    public char getFirstCharOnce(String str){
        if (str == null || str.length() <= 0)
            return '\0';
        int votes[] = new int[128];
        for (char ch : str.toCharArray())
            votes[ch]++;

        int firstIndex = Integer.MAX_VALUE;
        for (int i = 0; i < votes.length; i++)
            if (votes[i] == 1 && str.indexOf(i) < firstIndex)
                firstIndex = str.indexOf(i);
        if (firstIndex < Integer.MAX_VALUE)
            return str.charAt(firstIndex);
        return '\0';
    }

    public static void main(String[] args) {

        FirstOnceChar35 tool = new FirstOnceChar35();

        System.out.println(tool.getFirstCharOnce(null));
        System.out.println("*********输入为null*********");
        System.out.println(tool.getFirstCharOnce(""));
        System.out.println("*********输入为\"\"*********");
        System.out.println(tool.getFirstCharOnce("abaccdeff"));
        System.out.println("*********输入为abaccdeff*********");
        System.out.println(tool.getFirstCharOnce("aabbccdd"));
        System.out.println("*********输入为aabbccdd*********");
        System.out.println(tool.getFirstCharOnce("abcdef"));
        System.out.println("*********输入为abcdef*********");
    }
}
