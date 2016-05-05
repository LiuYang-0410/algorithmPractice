package 剑指offer;

/**
 * Created by liuyang on 16/4/23.
 */
public class OnceNumber40 {

    /**
     * 找到只出现一次的数字
     * @param num   给定数组
     * @return  两个只出现一次的数字
     */
    public int[] getNumberAppearOnce(int num[]){
        if (num == null || num.length <= 1)
            return null;
        int temp = 0;
        for (int i : num)   //两个不同的数异或的结果
            temp ^= i;
        int template = 1;
        while ((temp & template) != 0)  //找到从低到高第一位为1的
            template = template << 1;
        int res1 = 0, res2 = 0;
        for (int i : num) {
            if ((i & template) != 0)
                res1 = res1 ^ i;
            else
                res2 = res2 ^ i;
        }
        int result[] = {res1,res2};
        return result;
    }

    public static void main(String[] args) {
        OnceNumber40 tool = new OnceNumber40();
        int num[] = {2,4,3,6,3,2,5,5};
        int res[] = tool.getNumberAppearOnce(num);
        for (int i : res){
            System.out.println(i);
        }
    }

}
