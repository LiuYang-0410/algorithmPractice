package leetcode;

import java.util.*;

/**
 * Created by ly_anna on 2016/5/24.
 */
public class LeetCode_15_3Sum {

    Set<List<Integer>> out;

    /**
     * 在数组中找a+b+c = 0,且abc非递减
     * @param nums  给定数组
     * @return  abc的列表
     */
    public List<List<Integer>> threeSum(int[] nums){   //18ms
        Set<List<Integer>> res = new HashSet<>();
        if (nums != null && nums.length >= 3) {
            Arrays.sort(nums);
            for (int c = 2, maxC = -(nums[0] + nums[1]),count = 0; c < nums.length && nums[c] <= maxC; c++) {
                if (nums[c] < 0)
                    continue;
                count = nums[c] != nums[c-1] ? 0 : count+1;
                if (count == 0){
                    int tempA = 0, tempB = c - 1;
                    while (tempA < tempB) {
                        int sum = nums[tempA] + nums[tempB] + nums[c];
                        if (sum < 0)
                            while (++ tempA < tempB && nums[tempA] == nums[tempA-1]);
                        else if (sum > 0)
                            while (-- tempB > tempA && nums[tempB] == nums[tempB+1]);
                        else{
                            res.add(Arrays.asList(nums[tempA], nums[tempB], nums[c]));
                            while (++ tempA < tempB && nums[tempA] == nums[tempA-1]);
                        }
                    }
                }else if (count == 1)
                    for (int i = 0,sum = nums[c]+nums[c-1]; i < c - 1; i++) {
                        if (nums[i] + sum == 0) {
                            res.add(Arrays.asList(nums[i], nums[c - 1], nums[c]));
                            break;
                        }
                    }
                else if(count == 2 && nums[c] + nums[c-1] + nums[c-2] == 0){
                    res.add(Arrays.asList(nums[c], nums[c-1], nums[c-2]));
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSum2(int[] nums){   //8ms
        List<List<Integer>> out = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return out;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length-2){
            if (nums[i] > 0)
                continue;
            int j = i+1, k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) out.add(Arrays.asList(nums[i],nums[j],nums[k]));
                if (sum <= 0) while (nums[j] == nums[++j] && j < k);
                if (sum >= 0) while (nums[k] == nums[--k] && k > j);
            }
            while (nums[i] == nums[++i] && i < nums.length-2);
        }
        return out;
    }

    public static void main(String[] args) {
        LeetCode_15_3Sum sum = new LeetCode_15_3Sum();
        {
            int nums[] = {-1,0,1,2,-1,-4};
            System.out.println(sum.threeSum(nums));
            System.out.println(sum.threeSum2(nums));
        }
        {
            int nums[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
            System.out.println(sum.threeSum(nums));
            System.out.println(sum.threeSum2(nums));
        }
        {
            int nums[] = {0,0,0,0};
            System.out.println(sum.threeSum(nums));
            System.out.println(sum.threeSum2(nums));
        }
        {
            int nums[] = {-2,0,0,1,2};
            System.out.println(sum.threeSum(nums));
            System.out.println(sum.threeSum2(nums));
        }
        {
            int nums[] = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
            System.out.println(sum.threeSum(nums));
            System.out.println(sum.threeSum2(nums));
        }
        {
            int nums[] = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
            System.out.println(sum.threeSum(nums));
            System.out.println(sum.threeSum2(nums));
        }
    }
}
