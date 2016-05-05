package 剑指offer;

/**
 * Created by liuyang on 16/4/23.
 */
public class ProbOfDiceSum43 {

    /**
     * n个骰子朝上一面的点数之和s,所有s的可能概率
     * @param n n个骰子
     */
    public void getProbOfNDiceSum(int n){
        if (n <= 0)
            return;
        //每个和s出现的次数
        //prob[1] prob[0]一个计算当前n下和s的次数,一个做辅助记录n-1下和s的次数
        int prob[][] = new int[2][n*6];
        int flag = 0;   //表示当前是哪个prob
        for (int i = 0; i < 6; i++)     //第一个骰子的结果
            prob[0][i] = 1;
        for (int i = 1; i < n; i++) {   //第i个骰子的结果
            int temp = 6*(i-1)-1;
            while (temp >= 0 && prob[1-flag][temp] != 0)
                prob[1-flag][temp--] = 0;
            for (int j = i-1; j < 6 * i; j++)  //第i-1个骰子的结果
                for (int k = 1; k <= 6 ; k++)
                    prob[1-flag][j+k] += prob[flag][j];
            flag = (flag+1)%2;
        }
        int count = (int) Math.pow(6,n);
        for (int i = n-1; i < prob[flag].length; i++)
            System.out.println(i+1+"的概率:\t"+1.0*prob[flag][i]/count);
    }

    public static void main(String[] args) {
        ProbOfDiceSum43 tool = new ProbOfDiceSum43();
        System.out.println("*******1个骰子和的概率*******");
        tool.getProbOfNDiceSum(1);
        System.out.println("*******2个骰子和的概率*******");
        tool.getProbOfNDiceSum(2);
        System.out.println("*******3个骰子和的概率*******");
        tool.getProbOfNDiceSum(3);
        System.out.println("*******4个骰子和的概率*******");
        tool.getProbOfNDiceSum(4);
    }
}
