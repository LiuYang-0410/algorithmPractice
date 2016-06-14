package leetcode;

import java.util.Arrays;

/**
 * Created by ly_anna on 2016/5/27.
 */
public class LeetCode_16_3SumClosest {
    /**
     * 找出三个数，其和最接近给定值
     * @param nums  数组
     * @param target    给定和
     * @return  最接近的和
     */
    public int threeSumClosest(int[] nums, int target) {    //5ms
        Arrays.sort(nums);
        int i = 0,diff = Integer.MAX_VALUE,result = 0;
        while (i < nums.length-2){
            int twoSum = target - nums[i],j = i+1, k = nums.length-1;
            if (2*nums[k] < twoSum){    //最大的和都小于target
                int temp = nums[k] + nums[k-1];
                if (Math.abs(temp-twoSum) < diff){
                    diff = Math.abs(temp-twoSum);
                    result = temp+nums[i];
                }
            }else if (2*nums[j] > twoSum){    //最小的和都大于target
                int temp = nums[j] + nums[j+1];
                if (Math.abs(temp-twoSum) < diff){
                    diff = Math.abs(temp-twoSum);
                    result = temp+nums[i];
                }
            }else{
                while (j < k){
                    int temp = nums[j] + nums[k];
                    if (temp == twoSum) return target;
                    if (temp <= twoSum) while (nums[j] == nums[++j] && j < k);
                    if (temp >= twoSum) while (nums[k] == nums[--k] && k > j);
                    if (Math.abs(temp-twoSum) < diff){
                        diff = Math.abs(temp-twoSum);
                        result = temp+nums[i];
                    }
                }
            }
            while (nums[i] == nums[++i] && i < nums.length-2);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_16_3SumClosest closestSum = new LeetCode_16_3SumClosest();
        {
            int num[] = {-1,2,1,-4};
            System.out.println(closestSum.threeSumClosest(num,1));
        }
        {
            int num[] = {1,1,1,1};
            System.out.println(closestSum.threeSumClosest(num,0));
        }
    }
}
