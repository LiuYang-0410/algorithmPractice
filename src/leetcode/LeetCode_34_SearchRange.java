package leetcode;

/**
 * Created by ly_anna on 2016/10/26.
 */
public class LeetCode_34_SearchRange {

    public static int[] searchRange(int[] nums, int target) {//7ms
        int begin = 0, end = nums.length-1, ans[] = new int[2];
        while (begin < end){
            int mid = begin + (end - begin)/2;  //让中点偏左
            if (nums[mid] < target)
                begin = mid +1;
            else
                end = mid ;
        }
        if (nums[begin] != target)
            return new int[]{-1,-1};
        ans[0] = begin;
        end = nums.length-1;
        while (begin < end){
            int mid = begin + (end - begin)/2 + 1;  //让中点偏右
            if (nums[mid] > target)
                end = mid - 1;
            else
                begin = mid ;
        }
        ans[1] = begin;
        return ans;
    }

    public static void main(String[] args) {
        int num[] = {5, 7, 7, 8, 8, 10};
        for (int i = 0; i < 11; i++) {
            int ans[] = searchRange(num,i);
            System.out.println("search " + i + " : " + ans[0] + " " + ans[1]);
        }
    }
}
