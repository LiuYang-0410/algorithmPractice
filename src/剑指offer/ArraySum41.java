package 剑指offer;

/**
 * Created by liuyang on 16/4/23.
 */
public class ArraySum41 {

    /**
     * 递增数组中和为sum的两个数
     * @param num   递增数组
     * @param sum   和
     */
    public void getTwoNumSumK(int num[],int sum){
        if (num == null || num.length <= 1){
            System.out.println("null");
            return;
        }
        int smallIndex = 0, bigIndex = num.length-1;
        while (smallIndex < bigIndex){
            int curSum = num[smallIndex]+num[bigIndex];
            if (curSum == sum)
                break;
            else if (curSum < sum)
                smallIndex++;
            else
                bigIndex--;
        }
        if (smallIndex >= bigIndex){
            System.out.println("null");
            return;
        }
        System.out.println(num[smallIndex]+"\t"+num[bigIndex]);
    }

    public void testTwoNumSumK(){
        int num[] = {1,2,4,7,11,15};
        System.out.println("***********存在***********");
        getTwoNumSumK(num,15);
        System.out.println("\n***********不存在***********");
        getTwoNumSumK(num,14);
    }

    /**
     * 打印和为sum的连续正数序列
     * @param num   递增数组
     * @param sum   指定和
     */
    public void printSubArrayBySum(int num[],int sum){
        if (num == null || num.length < 1)
            return;
        if (num.length == 1){
            if (num[0] == sum)
                System.out.println(num[0]);
            else
                return;
        }
        int small = 0, big = 1,curSum = num[0]+num[1];
        while (small <= sum/2 && big < num.length){
            if (curSum == sum){
                printSubArray(num,small,big);
                curSum -= num[small++];
            }else if (curSum > sum)
                curSum -= num[small++];
            else if (curSum < sum && big != num.length-1)
                curSum += num[++big];
            else
                break;
        }
    }

    private void printSubArray(int num[],int begin,int end){
        for (int i = begin; i <= end ; i++)
            System.out.print(num[i]+"\t");
        System.out.println();
    }

    public void testSubArraySum(){
        int num[] = {1,2,3,4,5,6,7,8};
        System.out.println("*********和为9的子序列*********");
        printSubArrayBySum(num,9);
        System.out.println("*********和为15的子序列*********");
        printSubArrayBySum(num,15);
    }


    public static void main(String[] args) {
        ArraySum41 tool = new ArraySum41();
        int num[] = {4,7,9,10,11,15};
        tool.getTwoNumSumK(num,17);
        tool.testSubArraySum();
    }
}
