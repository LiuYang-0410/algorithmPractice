package leetcode;

/**
 * Created by liuyang on 16/4/13.
 */
public class LeetCode_52_NQueensII {

    int solutions;

    /**
     * N皇后问题,有多少种不同的放置方法
     * @param n N皇后问题
     * @return 不同的放置方法
     */
    public int totalNQueens(int n) {
        solutions = 0;
        int templates[] = new int[n];
        for (int i = 0; i < n; i++)
            templates[i] = i;
        helper(templates,0);
        return solutions;
    }

    private void helper(int templates[],int curIndex){
        if (curIndex == templates.length-1){//放置到最后一个皇后
            if (test(templates,templates.length-1))
                solutions++;
            return;
        }
        for (int i = curIndex; i < templates.length; i++) {
            swap(templates,curIndex,i);
            if (test(templates,curIndex))
                helper(templates,curIndex+1);
            swap(templates,curIndex,i);
        }
    }

    private void swap(int num[],int i,int j){
        if (i == j)
            return;
        int copyI = num[i];
        num[i] = num[j];
        num[j] = copyI;
    }

    /**
     * 检测是否合格的放置方式
     * @param templates 某种放置方式
     * @param beforeIndex 此位置之前是否满足条件(包含)
     * @return  是否合格
     */
    private boolean test(int templates[],int beforeIndex){
        //是否同一对角线
        for (int i = 0; i < beforeIndex; i++) {
            if (i - beforeIndex == templates[i] - templates[beforeIndex]    //正对角线
                        || beforeIndex -i == templates[i] - templates[beforeIndex]) //反对角线
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_52_NQueensII tool = new LeetCode_52_NQueensII();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 11; i++)
            System.out.println(i+"皇后问题有"+tool.totalNQueens(i)+"种不同解");
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-begin));
    }
}
