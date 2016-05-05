package 剑指offer;

/**
 * Created by liuyang on 16/4/25.
 */
public class DuplicateNumber51 {

    /**
     * 在数组中找到重复数
     * @param num   长度为n,所有数字都在0~n-1,不知道几个数重复几次
     * @return  任意重复数
     */
    public int getDuplicateNum(int num[]){
        if (num == null || num.length <= 1)
            return -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != i){
                int m = num[i];
                if (m == num[m])
                    return m;
                num[i] = num[m];
                num[m] = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DuplicateNumber51 tool = new DuplicateNumber51();
        int num[] = {2,3,1,0,2,5,3};
        System.out.println(tool.getDuplicateNum(num));
    }
}
