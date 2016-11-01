package leetcode;

import java.util.*;

/**
 * Created by ly_anna on 2016/10/28.
 */
public class LeetCode_39_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        //helper(ans,new ArrayList<Integer>(),candidates,target,0);
        helper2(ans,new ArrayList<Integer>(),candidates,target,0);
        return ans;
    }

    //无重复数字，可重复取
    private static void helper(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int target, int begin){//17ms
        if (target == 0)
            ans.add(new ArrayList<Integer>(cur));
        else {
            for (int i = begin; i < candidates.length; i++) {
                if (candidates[i] > target)
                    break;
                cur.add(candidates[i]);
                //helper(ans,cur,candidates,target-candidates[i],i);
                helper(ans,cur,candidates,target-candidates[i],i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    //有重复数字，不可重复取
    private static void helper2(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int target, int begin){//19ms
        if (target == 0)
            ans.add(new ArrayList<Integer>(cur));
        else {
            for (int i = begin; i < candidates.length; i++) {
                if (i > begin && candidates[i] == candidates[i-1])
                    continue;
                if (candidates[i] > target)
                    break;
                cur.add(candidates[i]);
                helper2(ans,cur,candidates,target-candidates[i],i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        {
            int candidate[] = {2, 3, 6, 7};
            List<List<Integer>> ans = combinationSum(candidate,7);
            for (List<Integer> a : ans) {
                System.out.println(a);
            }
        }
        {
            int candidate[] = {10,1,2,7,6,1,5};
            List<List<Integer>> ans = combinationSum(candidate,8);
            for (List<Integer> a : ans) {
                System.out.println(a);
            }
        }
        {
            int candidate[] = {2,2,2};
            List<List<Integer>> ans = combinationSum(candidate,4);
            for (List<Integer> a : ans) {
                System.out.println(a);
            }
        }
    }
}
