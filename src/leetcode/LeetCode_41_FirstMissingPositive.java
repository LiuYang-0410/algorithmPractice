package leetcode;

public class LeetCode_41_FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
    	for (int index = 1; index <= nums.length; index++) {
    		if (nums[index-1] != index && nums[index-1] > 0 && nums[index-1] <= nums.length) {
				int copy = nums[nums[index-1]-1];
				if (copy == nums[index-1]) 
					continue;
				nums[nums[index-1]-1] = nums[index-1];
				nums[--index] = copy;
			}
		}
    	for (int index = 1;  index <= nums.length; index++) 
			if (index != nums[index-1]) 
				return index;
    	return nums.length+1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			int num[] = {};
			System.out.println("1 : " + firstMissingPositive(num));
		}
		{
			int num[] = {0};
			System.out.println("1 : " + firstMissingPositive(num));
		}
		{
			int num[] = {1};
			System.out.println("2 : " + firstMissingPositive(num));
		}
		{
			int num[] = {1,1};
			System.out.println("2 : " + firstMissingPositive(num));
		}
		{
			int num[] = {1,2,0};
			System.out.println("3 : " + firstMissingPositive(num));
		}
		{
			int num[] = {3,4,-1,1};
			System.out.println("2 : " + firstMissingPositive(num));
		}
		{
			int num[] = {2,3,-1,1};
			System.out.println("4 : " + firstMissingPositive(num));
		}
		{
			int num[] = {1000,-1};
			System.out.println("1 : " + firstMissingPositive(num));
		}
	}

}
