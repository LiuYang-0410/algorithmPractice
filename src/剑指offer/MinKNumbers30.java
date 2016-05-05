package 剑指offer;

/**
 * Created by liuyang on 16/4/14.
 */
public class MinKNumbers30 {

    /**
     * 找到数据中最小的k个数,适合小数据,会改变原始数据,速度快O(n)
     * @param input 输入
     * @param k K个数
     * @return  最小的k个数
     */
    public int [] minKNumbersForSmallInput(int input[],int k){//快速选择
        if (input == null || input.length <= 0 || k <= 0)
            return null;
        if (k >= input.length)
            return input;
        int begin = 0,end = input.length-1;
        while (begin <= end){
            int pivot = begin;
            for (int i = begin+1; i <= end; i++)
                if (input[i] <= input[pivot]){
                    int copy = input[i];
                    input[i] = input[pivot+1];
                    input[pivot+1] = input[pivot];
                    input[pivot++] = copy;
                }
            if (pivot == k-1){  //找到最小k个数
                int result[] = new int[k];
                for (int i = 0; i < k; i++)
                    result[i] = input[i];
                return result;
            }else if (pivot < k-1)
                begin = pivot+1;
            else
                end = pivot-1;
        }
        return null;
    }

    /**
     * 找到数据中最小的k个数,适合大数据无法一次装入内存,不会改变原始数据,O(nlogk)
     * @param input 输入
     * @param k k个数
     * @return 最小的k个数
     */
    public int [] minKNumbersForMassInput(int input[],int k){
        if (input == null || input.length <= 0 || k <= 0)
            return null;
        int res[] = new int[k];
        for (int i = 0; i < k; i++)    //装入K个数据
            res[i] = input[i];
        buildMaxHeap(res);  //建立最大堆
        for (int i = k; i < input.length; i++)
            if (input[i] < res[0])  {//当前数小于堆中最大值
                res[0] = input[i];
                maxHeapify(res,1,k);    //调整最大堆
            }
        return res;
    }

    /**
     * 调整最大堆,使其满足最大堆的性质
     * @param num   最大堆数组
     * @param i 从第i+1个节点开始调整
     * @param heapSize  堆得大小
     */
    private void maxHeapify(int num[],int i,int heapSize){
        int leftIndex = i*2;
        int rightIndex = leftIndex+1;
        int largestIndex = i;
        if(leftIndex <= heapSize && num[leftIndex-1] > num[largestIndex-1])
            largestIndex = leftIndex;
        if(rightIndex <= heapSize && num[rightIndex-1] > num[largestIndex-1])
            largestIndex = rightIndex;
        if(largestIndex != i){
            int copy = num[i-1];
            num[i-1] = num[largestIndex-1];
            num[largestIndex-1] = copy;
            maxHeapify(num,largestIndex,heapSize);
        }
    }

    /**
     * 建立最大堆
     * @param num 最大堆数组
     */
    private void buildMaxHeap(int num[]){
        for(int i = num.length/2; i>= 0; i--)
            maxHeapify(num,i+1,num.length);
    }

    public static void main(String[] args) {
        MinKNumbers30 tool = new MinKNumbers30();
        {
            System.out.println("*************使用快速选择*************");
            int num[] = {4,5,1,6,2,7,3,8};
            for (int i = 0; i < 10; i++) {
                System.out.print("最小的"+i+"个数:\t");
                int res[] = tool.minKNumbersForSmallInput(num,i);
                if (res != null && res.length > 0)
                    for (int j : res)
                        System.out.print(j+"\t");
                else
                    System.out.print("null");
                System.out.println();
            }
        }
        {
            System.out.println("*************使用最大堆*************");
            int num[] = {4,5,1,6,2,7,3,8};
            for (int i = 0; i < num.length; i++) {
                System.out.print("最小的"+i+"个数:\t");
                int res[] = tool.minKNumbersForMassInput(num,i);
                if (res != null && res.length > 0)
                    for (int j : res)
                        System.out.print(j+"\t");
                else
                    System.out.print("null");
                System.out.println();
            }
        }
    }
}
