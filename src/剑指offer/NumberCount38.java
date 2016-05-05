package 剑指offer;

/**
 * Created by liuyang on 16/4/22.
 */
public class NumberCount38 {

    /**
     * 数字在排序数组中出现的次数
     * @param sortedArr 排序数组
     * @param num   给定数字
     * @return  出现次数
     */
    public int countNumberInSortedArray(int sortedArr[],int num){
        if (sortedArr == null || sortedArr.length <= 0)
            return 0;
        int firstNum = getFirstK(sortedArr,num,0,sortedArr.length-1);
        if (firstNum == -1)
            return 0;
        int lastNum = getLastK(sortedArr,num,0,sortedArr.length-1);
        return lastNum-firstNum+1;
    }

    public int getFirstK(int num[],int k, int begin, int end){
        if (begin == end){
            if (num[begin] == k)
                return begin;
            else
                return -1;
        }
        int mid = (begin+end)/2;
        if (num[mid] < k)
            return getFirstK(num,k,mid+1,end);
        else if (num[mid] > k)
            return getFirstK(num,k,begin,mid);
        else if (mid== 0 || num[mid+1] != k)
            return mid;
        else
            return getFirstK(num,k,begin,mid);
    }

    public int getLastK(int num[],int k, int begin, int end){
        if (begin == end){
            if (num[begin] == k)
                return begin;
            else
                return -1;
        }
        int mid = (begin+end)/2;
        if (num[mid] < k)
            return getFirstK(num,k,mid+1,end);
        else if (num[mid] > k)
            return getFirstK(num,k,begin,mid);
        else if (mid== end || num[mid+1] != k)
            return mid;
        else
            return getFirstK(num,k,mid+1,end);
    }

    public static void main(String[] args) {
        NumberCount38 tool = new NumberCount38();
        System.out.print("原数组:\t");
        int num[] = {1,2,3,3,3,3,4,5};
        for (int i : num)
            System.out.print(i+"\t");
        System.out.println();
        System.out.println("************查找不存在的************");
        System.out.println(tool.countNumberInSortedArray(num,7));
        System.out.println("************查找2(1次)************");
        System.out.println(tool.countNumberInSortedArray(num,2));
        System.out.println("************查找4(1次)************");
        System.out.println(tool.countNumberInSortedArray(num,4));
        System.out.println("************查找3(多次)************");
        System.out.println(tool.countNumberInSortedArray(num,3));
    }
}
