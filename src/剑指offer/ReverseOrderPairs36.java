package 剑指offer;

/**
 * Created by liuyang on 16/4/22.
 */
public class ReverseOrderPairs36 {

    int reversePairs;   //逆序对的个数

    /**
     * 统计数组中的逆序对
     * @param num   数组
     * @return 逆序对的个数
     */
    public int countReverseOrder(int num[]){
        reversePairs = 0;
        if (num == null || num.length <= 1)
            return 0;
        divide(num,0,num.length-1);
        return reversePairs;
    }

    private void divide(int num[],int begin,int end){
        if (begin == end)
            return;
        int mid = (begin+end)/2;
        divide(num,begin,mid);
        divide(num,mid+1,end);

        //merge
        int result[] = new int[end-begin+1];
        int p1 = mid,p2 = end;
        for (int i = result.length-1; i >= 0 && p1 >= begin && p2 > mid ; i--) {
            if (num[p1] > num[p2]){ //存在逆序对
                result[i] = num[p1--];
                reversePairs += p2-mid;
            }else //不存在
                result[i] = num[p2--];
        }
        for (int i = begin; i <= p1; i++)
            result[i-begin] = num[i];
        for (int i = mid+1; i <= p2; i++)
            result[i-mid-1] = num[i];
        for (int i = 0; i < result.length; i++)
            num[begin+i] = result[i];
    }

    public static void main(String[] args) {
        ReverseOrderPairs36 tool = new ReverseOrderPairs36();
        {
            System.out.print("********只包含2个数的数组********\n原数组:\t");
            int num[] = {2,1};
            for (int i : num)
                System.out.print(i+"\t");
            System.out.println("\n"+tool.countReverseOrder(num));
        }
        {
            System.out.print("********只包含1个数的数组********\n原数组:\t");
            int num[] = {1};
            for (int i : num)
                System.out.print(i+"\t");
            System.out.println("\n"+tool.countReverseOrder(num));
        }
        {
            System.out.print("********未排序的数组********\n原数组:\t");
            int num[] = {7,5,6,4};
            for (int i : num)
                System.out.print(i+"\t");
            System.out.println("\n"+tool.countReverseOrder(num));
        }
        {
            System.out.print("********递增排序的数组********\n原数组:\t");
            int num[] = {1,2,3,4,5,6,7,8,9};
            for (int i : num)
                System.out.print(i+"\t");
            System.out.println("\n"+tool.countReverseOrder(num));
        }
        {
            System.out.print("********递减排序的数组********\n原数组:\t");
            int num[] = {9,8,7,6,5,4,3,2,1};
            for (int i : num)
                System.out.print(i+"\t");
            System.out.println("\n"+tool.countReverseOrder(num));
        }
        {
            System.out.print("********包含重复数的数组********\n原数组:\t");
            int num[] = {7,4,5,7,6,6,4};
            for (int i : num)
                System.out.print(i+"\t");
            System.out.println("\n"+tool.countReverseOrder(num));
        }
    }
}
