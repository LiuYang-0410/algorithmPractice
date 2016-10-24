package leetcode;

/**
 * Created by ly_anna on 2016/10/24.
 */
public class LeetCode_33_RotatedArray {

    public static int search2(int[] nums, int target) {
        return helper(nums,target,0,nums.length-1);
    }

    static int helper(int[] nums, int target, int begin, int end){
        if (begin > end)
            return -1;
        if (begin == end)
            return nums[begin] == target ? begin : end;
        int mid = begin + (end - begin)/2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target){
            if (mid > begin && nums[mid-1] < nums[mid])
                return helper(nums,target,begin,mid-1);
            if (mid < end && nums[mid+1] < nums[mid])
                return helper(nums,target,mid+1,end);
        }else {
            if (mid < end && nums[mid+1] > nums[mid])
                return helper(nums,target,mid+1,end);
            if (mid > begin && nums[mid-1] < nums[mid])
                return helper(nums,target,begin,mid-1);
        }
        return -1;
    }
    public static int search(int[] nums, int target) {//16ms
        if (target >= nums[0]){
            for (int i = 0; i < nums.length && nums[i] >= nums[0]; i++)
                if (target == nums[i])
                    return i;
            return -1;
        }
        if (target <= nums[nums.length-1]){
            for (int i = nums.length-1; i > 0 && nums[i] <= nums[nums.length-1]; i--)
                if (target == nums[i])
                    return i;
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int num[] = {4,5,6,7,0,1,2};
        for (int i = -1; i < 10; i++){
            System.out.println(i + ":\t" + search(num,i));
            System.out.println(i + ":\t" + search2(num,i));
        }


    }
}
