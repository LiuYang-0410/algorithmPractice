package leetcode;

/**
 * Created by ly_anna on 2016/10/26.
 */
public class LeetCode_35_InsertPosition {

    public static int searchInsert(int[] nums, int target) {//5ms
        int begin = 0, end = nums.length-1;
        while (begin <= end){
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        return begin;
    }

    public static void main(String[] args) {
        int num[] = {1,3,5,6};
        for (int i = 0; i < 10; i++) {
            System.out.println("search " + i + " : " + searchInsert(num,i));
        }
    }

}
