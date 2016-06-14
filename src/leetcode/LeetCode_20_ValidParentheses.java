package leetcode;

import java.util.Stack;

/**
 * Created by ly_anna on 2016/5/31.
 */
public class LeetCode_20_ValidParentheses {

    static char pairs[] = new char[128];
    {
        pairs[')'] = '(';
        pairs['}'] = '{';
        pairs[']'] = '[';
    }

    /**
     * 给定由'(', ')', '{', '}', '[' and ']'组成的字符串，判断其是否正确
     */
    public boolean isValid(String s) {  //1ms
        if ((s.length() & 0x1) == 1)
            return false;
        Stack<Character> chs = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                chs.push(ch);
            else if (!chs.isEmpty() && chs.peek() == pairs[ch])
                chs.pop();
            else
                return false;
        }
        return chs.isEmpty();
    }

    public boolean isValid2(String s) {  //0ms
        if ((s.length() & 0x1) == 1)
            return false;
        char chs[] = new char[s.length()];
        int index = -1;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                chs[++index] = ch;
            else if (index > -1 && chs[index] == pairs[ch])
                index--;
            else
                return false;
        }
        return index == -1;
    }

    public static void main(String[] args) {
        LeetCode_20_ValidParentheses validParentheses = new LeetCode_20_ValidParentheses();
        System.out.println("*******************TRUE*********************");
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid2("()"));
        System.out.println(validParentheses.isValid("([]{})"));
        System.out.println(validParentheses.isValid2("([]{})"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid2("()[]{}"));
        System.out.println(validParentheses.isValid("(())"));
        System.out.println(validParentheses.isValid2("(())"));
        System.out.println("*******************FALSE*********************");
        System.out.println(validParentheses.isValid("["));
        System.out.println(validParentheses.isValid2("["));
        System.out.println(validParentheses.isValid("]"));
        System.out.println(validParentheses.isValid2("]"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid2("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid2("([)]"));
    }
}
