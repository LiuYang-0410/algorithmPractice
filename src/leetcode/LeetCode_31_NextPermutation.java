package leetcode;

import base.PrintSolution;

/**
 * Created by ly_anna on 2016/8/21.
 */
public class LeetCode_31_NextPermutation {

    public void nextPermutation(int[] nums) {//1ms
        int start = nums.length-2, end = start + 1;
        while (start >= 0 && nums[start] >= nums[start+1])  start--; //find the last reversed order
        if (start >=  0){
            for (int i = start+1, pivot = nums[start];i <= end + 1; i++) {
                if ( i> end || nums[i] <= nums[start]){
                    nums[start++] = nums[i-1];
                    nums[i-1] = pivot;
                    break;
                }
            }
        }else {
            start = 0;
        }
        for (int i = start, j = end; i < j; i++,j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static void test(){
        LeetCode_31_NextPermutation nextPermutation = new LeetCode_31_NextPermutation();
        {
            int nums[] = {1,2,3,4};
            PrintSolution.printArray(nums,"original:");
            for (int i = 0; i <= 24; i++) {
                nextPermutation.nextPermutation(nums);
                PrintSolution.printArray(nums,"-------"+i+":");
            }
        }
        int nums[] = {1,5,1};
        PrintSolution.printArray(nums, "original:");
        nextPermutation.nextPermutation(nums);
        PrintSolution.printArray(nums, "------- " + ":");
    }
}
