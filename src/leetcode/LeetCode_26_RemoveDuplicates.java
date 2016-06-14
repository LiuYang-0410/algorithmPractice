package leetcode;

import java.util.Arrays;

/**
 * Created by ly_anna on 2016/6/14.
 */
public class LeetCode_26_RemoveDuplicates {

    /**
     * 删除排序数组中的重复元素
     * @param nums 排序数组
     * @return 剩余的数组长度
     */
    public int removeDuplicates(int[] nums) {   //2ms
        if (nums.length <= 1)
            return nums.length;
        int i = 0,j = 1;
        while (j < nums.length)
            if (nums[j] != nums[i]) nums[++i] = nums[j++];
            else j++;
        return i+1;
    }

    public static void main(String[] args) {
        LeetCode_26_RemoveDuplicates removeDuplicates = new LeetCode_26_RemoveDuplicates();
        int nums[] = {1,1,2,2,3,4,6,6,6,6};
        int length = removeDuplicates.removeDuplicates(nums);
        System.out.println("长度："+ length);
        for (int i = 0; i < length; i++)
            System.out.print(nums[i]+"\t");
    }
}
