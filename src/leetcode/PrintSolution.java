package leetcode;

/**
 * Created by liuyang on 16/5/2.
 */
public class PrintSolution {

    /**
     * 打印数组 1\t2\t...
     * @param array 打印的数组
     */
    public static void printArray(int array[]){
        for (int num : array)
            System.out.print(num+"\t");
        System.out.println();
    }
}
