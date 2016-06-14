package leetcode;

/**
 * Created by ly_anna on 2016/6/14.
 */
public class LeetCode_27_RemoveElement {

    /**
     * 从数组中移除指定值
     */
    public int removeElement(int[] nums, int val) {//0ms
        int length = nums.length,i = 0;
        while(i < length){
            if (nums[i] == val)
                nums[i] = nums[--length];
            else
                i++;
        }
        return length;
    }

    public static void main(String[] args) {
        LeetCode_27_RemoveElement removeElement = new LeetCode_27_RemoveElement();
        for (int i = 0; i < 10; i++) {
            int num[] = {2,4,2,54,1,56,1,6,2,7,2,4,7};
            int length = removeElement.removeElement(num,i);
            System.out.print("remove "+i+":\t");
            for (int j = 0; j < length; j++)
                System.out.print(num[j]+"\t");
            System.out.println();
        }
    }
}
