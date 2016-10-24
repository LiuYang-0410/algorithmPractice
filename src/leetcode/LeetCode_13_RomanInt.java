package leetcode;

import sun.invoke.util.VerifyAccess;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ly_anna on 2016/5/21.
 */
public class LeetCode_13_RomanInt {

    static Map<Integer,Integer> map;

    static {
        map = new HashMap<>(13);
        map.put(77,1000);
        map.put(144,900);
        map.put(68,500);
        map.put(135,400);
        map.put(67,100);
        map.put(155,90);
        map.put(76,50);
        map.put(164,40);
        map.put(88,10);
        map.put(161,9);
        map.put(86,5);
        map.put(159,4);
        map.put(73,1);
    }

    /**
     * 将罗马数组转换为十进制整数
     * @param s 给的罗马数字，1-3999
     * @return  对应十进制整数
     */
    public int romanToInt(String s) {   //13ms
        int out = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1 && map.get((int)s.charAt(i)) < map.get((int)s.charAt(i+1)))
                out += map.get(s.charAt(i++)+s.charAt(i));
            else
                out += map.get((int)s.charAt(i));
        }
        return out;
    }

    private static String keys[] = {"M","CM","D","CD","C","XC","L","XL", "X","IX","V","IV","I"};
    private static int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public int romanToInt2(String s){   //8ms
        int out = 0;
        for (int i = 0,index = 0; index < s.length() && i < keys.length; i++) {
            while (index < s.length() && s.startsWith(keys[i],index)){
                out += values[i];
                index += keys[i].length();
            }
        }
        return out;
    }

    static int romans[] = new int[26];
    static {
        romans['M' - 'A'] = 1000;
        romans['D' - 'A'] = 500;
        romans['C' - 'A'] = 100;
        romans['L' - 'A'] = 50;
        romans['X' - 'A'] = 10;
        romans['V' - 'A'] = 5;
        romans['I' - 'A'] = 1;
    }

    public int romanToInt3(String s){   //7ms
        int out = 0, old = 1000;
        for (char ch : s.toCharArray()) {
            int value = romans[ch - 'A'];
            if (old < value)
                out = out + value - 2*old;
            else
                out += value;
            old = value;
        }
        return out;
    }

    public static void main(String[] args) {
        LeetCode_13_RomanInt romanInt = new LeetCode_13_RomanInt();
        String test[] = {"I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
        "XXX","XL","L","LX","LXX","LXXX","XC","XCIX","C","CI","CII",
        "CC","CCC","CD","D","DC","DCC","DCCC","CM","M","MCD","MCDXXXVII","MD","MDCCC","MDCCCLXXX","MCM","MM","MMM","MMMCCCXXXIII",
        "MDLXX"};
        for (String str : test) {
            System.out.println(str+":\t"+ romanInt.romanToInt(str));
            System.out.println(str+":\t"+ romanInt.romanToInt2(str));
            System.out.println(str+":\t"+ romanInt.romanToInt3(str));
        }
    }
}
