package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ly_anna on 2016/5/29.
 */
public class LeetCode_18_4Sum {

    List<List<Integer>> ans;
    int index[];
    /**
     * 在n个数中找到和为指定值的四个数
     * @param nums  n个数
     * @param target    和
     * @return  所有满足条件的数的集合
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {    //43ms
        ans = new ArrayList<>();
        if (nums.length < 4)
            return ans;
        Arrays.sort(nums);
        index = new int[4];
        helper(0,nums,target);
        return ans;
    }

    private void helper(int count, int nums[], int target){
        if (count == 2){    //最后两个数
            int m = index[count-1]+1, n = nums.length-1;
            while (m < n){  //第三个数和第四个数
                if (2*nums[m] > target)
                    break;
                int temp = nums[m] + nums[n];
                if (temp == target) ans.add(Arrays.asList(nums[index[0]],nums[index[1]],nums[m],nums[n]));
                if (temp <= target) while (m < n && nums[m] == nums[++m]);
                if (temp >= target) while (m < n && nums[n] == nums[--n]);
            }
        }else {
            int end = nums.length - 3 + count;
            int j = count == 0 ? 0 : index[count-1]+1;
            while (j < end){
                if ( (4-count)*nums[j] > target )
                    break;
                index[count] = j;
                helper(count+1,nums,target-nums[j]);
                while (j < end && nums[j] == nums[++j]);
            }
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target){    //7ms
        List<List<Integer>> myAns = new ArrayList<>();
        if (nums.length < 4)
            return myAns;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;    //最小的都大于目标值
            if (nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target) continue;  //num[i]是无用的
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                if (nums[i] + nums[j] + nums[j+1] +nums[j+2] > target)    break;  //最小的都大于目标值
                if (nums[i] + nums[j] + nums[nums.length-1]+nums[nums.length-2] < target) continue;   //num[j]是无用的
                int m = j + 1, n = nums.length-1,restTarget = target - nums[i] - nums[j];
                while (m < n){
                    int temp = nums[m] + nums[n];
                    if (temp == restTarget) myAns.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                    if (temp <= restTarget) while (nums[m] == nums[++m] && m < n);
                    if (temp >= restTarget) while (nums[n] == nums[--n] && m < n);
                }
            }
        }
        return myAns;
    }

    public static void main(String[] args) {
        LeetCode_18_4Sum sum = new LeetCode_18_4Sum();
        {
            int nums[] = {1,0,-1,0,-2,2};
            System.out.println(sum.fourSum(nums,0));
            System.out.println(sum.fourSum2(nums,0));
        }
    }
}
