package 剑指offer;

/**
 * Created by liuyang on 16/4/22.
 */
public class UglyNumber34 {

    int factor[] = {2,3,5};

    /**
     * 返回第k个丑数
     */
    public int kthUglyNumber(int k){
        int result[] = new int[k];
        result[0] = 1;
        int factorIndex[] = new int[factor.length];
        for (int i = 1; i < k; i++) {
            int minIndex = 0,min = factor[minIndex]*result[factorIndex[minIndex]];
            for (int j = 1; j < factor.length; j++){
                int cur = factor[j]*result[factorIndex[j]];
                if (cur == result[i-1]){
                    factorIndex[j]++;
                    cur = factor[j]*result[factorIndex[j]];
                }
                if (cur < min){
                    minIndex = j;
                    min = cur;
                }
            }
            result[i] = min;
            factorIndex[minIndex]++;
        }
        return result[k-1];
    }

    public static void main(String[] args) {
        UglyNumber34 tool = new UglyNumber34();
        for (int i = 1; i < 20; i++) {
            System.out.println("第"+i+"个丑数:"+tool.kthUglyNumber(i));
        }
    }

}
