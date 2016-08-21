package leetcode;

import base.PrintSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyang on 16/5/2.
 */
public class LeetCode_1_TwoSum {

    /**
     * 返回两数相加等于目标值的索引
     * @param nums  给定数组
     * @param target    相加的和
     * @return  那两个数的索引
     */
    public int[] twoSum(int[] nums, int target) {   //普通遍历 43ms
        for (int i = 0; i < nums.length; i++)
            for (int j = i+1; j < nums.length; j++)
                if (nums[i] + nums[j] == target){
                    int result[] = {i,j};
                    return result;
                }
        return null;
    }

    public int[] twoSum2(int[] nums, int target){   //先排序再遍历,5ms
        int sorted[] = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);
        int i=0,j=sorted.length-1;
        while (true){
            while (sorted[i] + sorted[j] > target)
                j--;
            while (sorted[i] + sorted[j] < target)
                i++;
            if (sorted[i]+sorted[j] == target)
                break;
        }
        int result[] = new int[2];
        for (int k = 0,resIndex=0; resIndex < 2 && k < nums.length; k++)
            if (nums[k] == sorted[i] || nums[k] == sorted[j])
                result[resIndex++] = k;
        return result;
    }

    public int[] twoSum3(int[] nums, int target){   //分治 18ms
        return helper3(nums,target,0,nums.length-1);
    }

    private int[] helper3(int[] nums, int target,int begin,int end){
        if (begin >= end)
            return null;
        int mid = (begin+end)/2;
        int leftResult[] = helper3(nums,target,begin,mid);
        if (leftResult != null)
            return leftResult;
        int rightResult[] = helper3(nums,target,mid+1,end);
        if (rightResult != null)
            return rightResult;
        for (int i = begin; i <= mid; i++)
            for (int j = mid+1; j <= end; j++)
                if (nums[i]+nums[j] == target){
                    int result[] = {i,j};
                    return result;
                }
        return null;
    }

    public int[] twoSum4(int[] nums, int target){   //类似希尔 8ms
        for (int diff = 1; diff < nums.length; diff++) //不同的diff
            for (int i = 0; i+diff < nums.length; i++)
                if (nums[i] + nums[i+diff] == target){
                    int result[] = {i,i+diff};
                    return result;
                }
        return null;
    }

    public int[] twoSum5(int[] nums, int target){   //hashMap 6ms
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                int result[] = {i,map.get(nums[i])};
                return result;
            }else {
                map.put(target-nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode_1_TwoSum tool = new LeetCode_1_TwoSum();
        {
            int nums[] = {3,2,4};
            System.out.print("原数组:\t");
            PrintSolution.printArray(nums);
            PrintSolution.printArray(tool.twoSum2(nums,6));
        }
        {
            int nums[] = {0,4,3,0};
            System.out.print("原数组:\t");
            PrintSolution.printArray(nums);
            PrintSolution.printArray(tool.twoSum2(nums,0));
        }
        {
            int nums[] = {-1,-2,-3,-4,-5};
            System.out.print("原数组:\t");
            PrintSolution.printArray(nums);
            PrintSolution.printArray(tool.twoSum2(nums,-8));
        }

        {
            int nums[] = {7, 15, 2, 11};
            System.out.print("原数组:\t");
            PrintSolution.printArray(nums);
            System.out.print("sum = 9:\t");
            PrintSolution.printArray(tool.twoSum2(nums,9));
            System.out.print("sum = 13:\t");
            PrintSolution.printArray(tool.twoSum2(nums,13));
            System.out.print("sum = 17:\t");
            PrintSolution.printArray(tool.twoSum2(nums,17));
            System.out.print("sum = 18:\t");
            PrintSolution.printArray(tool.twoSum2(nums,18));
            System.out.print("sum = 22:\t");
            PrintSolution.printArray(tool.twoSum2(nums,22));
            System.out.print("sum = 26:\t");
            PrintSolution.printArray(tool.twoSum2(nums,26));
        }
    }
}
