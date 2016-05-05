package 剑指offer;

/**
 * Created by liuyang on 16/4/24.
 */
public class PokerJunko44 {

    /**
     * 判断给定的扑克牌是否构成顺子
     * @param num   给定扑克牌,0-13
     * @return  是否是顺子
     */
    public boolean isJunko(int num[]){
        int count[] = new int[13],min = 14, max = 0,k=0;
        for (int i : num) {
            if (i == 0) //遇到大小王
                k++;
            else {
                if (count[i-1]++ == 1)    //若有重复出现构成对子,不为顺子
                    return false;
                min = Math.min(min,i);
                max = Math.max(max,i);
            }
        }
        int temp = num.length - 1 - max + min;
        return temp >= 0 && temp <= k;
    }

    public static void main(String[] args) {
        PokerJunko44 tool = new PokerJunko44();
        int num[] = {2,3,4,5,6};
        System.out.print("抽取扑克:\t2\t3\t4\t5\t6");
        System.out.println("\n是否是顺子:\t"+tool.isJunko(num));
        for (int j = 0; j < 10; j++) {
            int poker[] = new int[5];
            System.out.print("抽取扑克:\t");
            for (int i = 0; i < poker.length; i++) {
                poker[i] = (int)(Math.random()*14);
                System.out.print(poker[i]+"\t");
            }
            System.out.println("\n是否是顺子:\t"+tool.isJunko(poker));
        }
    }

}
