package 剑指offer;

/**
 * Created by liuyang on 16/4/14.
 */
public class MaxSumOfSubArray {

    public int findMaxSubArraySum(int num[]){
        if (num == null || num.length <= 0)
            return 0;
        int oldSum = 0,maxSum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0) //和减少之前,保存旧和
                oldSum = Math.max(oldSum,maxSum);
            maxSum += num[i];   //加上当前数
            if (maxSum < 0) //如果到此的子数组和已小于0,则不考虑这一段
                maxSum = 0;
        }
        return Math.max(oldSum,maxSum);
    }

    public static void main(String[] args) {
        MaxSumOfSubArray tool = new MaxSumOfSubArray();
        int num[] = {1,-2,3,10,-4,7,2,-5};
        System.out.println(tool.findMaxSubArraySum(num));
    }

}
