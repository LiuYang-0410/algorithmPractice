package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ly_anna on 2016/5/20.
 */
public class LeetCode_12_IntRoman {

    static Map<Integer,Character> map;

    static {
        map = new HashMap<>(7);
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');
    }

    /**
     * 数字转罗马数字
     * @param num   输入整数 1-3999
     * @return  对应的罗马数字
     */
    public String intToRoman(int num) { //15ms
        StringBuffer sb = new StringBuffer();
        int base = 1000;
        while ( base > num)
            base /= 10;
        while (base > 0){
            int temp = num / base;
            if (temp == 9){
                sb.append(map.get(base)).append(map.get(10*base));
            }else if (temp == 4){
                sb.append(map.get(base)).append(map.get(5*base));
            }else{
                if (temp >= 5){
                    sb.append(map.get(5*base));
                    temp -= 5;
                }
                while (temp-- > 0)
                    sb.append(map.get(base));
            }
            num %= base;
            base /= 10;
        }
        return sb.toString();
    }

    public enum Roman{
        M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
        private final int value;
        Roman(int value){
            this.value = value;
        }
    }

    public String intToRoman2(int num){ //11MS
        StringBuffer out = new StringBuffer();
        for (Roman roman : Roman.values()) {
            while (num >= roman.value){
                out.append(roman);
                num -= roman.value;
            }
        }
        return out.toString();
    }

    private static String M[] = {"","M","MM","MMM"};
    private static String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    public String intToRoman3(int num){ //8ms
        StringBuffer out = new StringBuffer();
        return out.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[(num%10)]).toString();
    }

    public static void main(String[] args) {
        LeetCode_12_IntRoman intRoman = new LeetCode_12_IntRoman();
        for (int i = 1; i <= 20 ; i++){
            System.out.println(i+" :\t"+intRoman.intToRoman(i));
            System.out.println(i+" :\t"+intRoman.intToRoman2(i));
            System.out.println(i+" :\t"+intRoman.intToRoman3(i));
        }
        for (int i = 3; i <= 9 ; i++){
            System.out.println(i*10 +" :\t"+intRoman.intToRoman(i*10));
            System.out.println(i*10 +" :\t"+intRoman.intToRoman2(i*10));
            System.out.println(i*10 +" :\t"+intRoman.intToRoman3(i*10));
        }
        System.out.println("99 :\t"+intRoman.intToRoman(99));
        System.out.println("99 :\t"+intRoman.intToRoman2(99));
        System.out.println("99 :\t"+intRoman.intToRoman3(99));
        System.out.println("101 :\t"+intRoman.intToRoman(101));
        System.out.println("101 :\t"+intRoman.intToRoman2(101));
        System.out.println("101 :\t"+intRoman.intToRoman3(101));
        System.out.println("102 :\t"+intRoman.intToRoman(102));
        System.out.println("102 :\t"+intRoman.intToRoman2(102));
        System.out.println("102 :\t"+intRoman.intToRoman3(102));
        for (int i = 1; i <= 10 ; i++){
            System.out.println(i*100 +" :\t"+intRoman.intToRoman(i*100));
            System.out.println(i*100 +" :\t"+intRoman.intToRoman2(i*100));
            System.out.println(i*100 +" :\t"+intRoman.intToRoman3(i*100));
        }
        System.out.println("1400 :\t"+intRoman.intToRoman(1400));
        System.out.println("1400 :\t"+intRoman.intToRoman2(1400));
        System.out.println("1400 :\t"+intRoman.intToRoman3(1400));
        System.out.println("1437 :\t"+intRoman.intToRoman(1437));
        System.out.println("1437 :\t"+intRoman.intToRoman2(1437));
        System.out.println("1437 :\t"+intRoman.intToRoman3(1437));
        System.out.println("1500 :\t"+intRoman.intToRoman(1500));
        System.out.println("1500 :\t"+intRoman.intToRoman2(1500));
        System.out.println("1500 :\t"+intRoman.intToRoman3(1500));
        System.out.println("1800 :\t"+intRoman.intToRoman(1800));
        System.out.println("1800 :\t"+intRoman.intToRoman2(1800));
        System.out.println("1800 :\t"+intRoman.intToRoman3(1800));
        System.out.println("1880 :\t"+intRoman.intToRoman(1880));
        System.out.println("1880 :\t"+intRoman.intToRoman2(1880));
        System.out.println("1880 :\t"+intRoman.intToRoman3(1880));
        System.out.println("1900 :\t"+intRoman.intToRoman(1900));
        System.out.println("1900 :\t"+intRoman.intToRoman2(1900));
        System.out.println("1900 :\t"+intRoman.intToRoman3(1900));
        System.out.println("2000 :\t"+intRoman.intToRoman(2000));
        System.out.println("2000 :\t"+intRoman.intToRoman2(2000));
        System.out.println("2000 :\t"+intRoman.intToRoman3(2000));
        System.out.println("3000 :\t"+intRoman.intToRoman(3000));
        System.out.println("3000 :\t"+intRoman.intToRoman2(3000));
        System.out.println("3000 :\t"+intRoman.intToRoman3(3000));
        System.out.println("3333 :\t"+intRoman.intToRoman(3333));
        System.out.println("3333 :\t"+intRoman.intToRoman2(3333));
        System.out.println("3333 :\t"+intRoman.intToRoman3(3333));
    }
}
