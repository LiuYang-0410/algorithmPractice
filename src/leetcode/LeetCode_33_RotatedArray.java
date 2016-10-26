package leetcode;

/**
 * Created by ly_anna on 2016/10/24.
 */
public class LeetCode_33_RotatedArray {

    public static int best(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while (low < high){
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        int rotateIndex = low;
        low = 0;
        high = nums.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            int realMid = (mid + rotateIndex) % nums.length;
            if (nums[realMid] == target)
                return realMid;
            if (nums[realMid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {//14ms
        int begin = 0, end = nums.length-1;
        while (begin <= end){
            int mid = begin + (end - begin)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > nums[end]){
                if (target >= nums[begin] && target < nums[mid])
                    end = mid - 1;
                else
                    begin = mid + 1;
            }else {
                if (target > nums[mid] && target <= nums[end])
                    begin = mid + 1;
                else
                    end = mid - 1;
            }
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
/*        int num[] = {3,1};
        System.out.println(search2(num,4));*/
        int num[] = {4,5,6,7,0,1,2};
        for (int i = -1; i < 10; i++){
            System.out.println(i + ":\t" + search(num,i));
            System.out.println(i + ":\t" + search2(num,i));
            System.out.println(i + ":\t" + best(num,i));
        }


    }
}
