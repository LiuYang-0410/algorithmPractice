package leetcode;

/**
 * Created by ly_anna on 2016/5/20.
 */
public class LeetCode_11_MostWater {
    /**
     * 求出能构成的最大面积
     * @param height    高度数组
     * @return  最大面积
     */
    public int maxArea(int[] height) { //3ms
        int left = 0, right = height.length-1,maxArea = 0;
        while (left < right){
            if (height[left] <= height[right]){
                maxArea = Math.max(maxArea,height[left]*(right-left));
                for (int i = left; left < height.length && height[left] <= height[i]; left++);
            }
            else{
                maxArea = Math.max(maxArea,height[right]*(right-left));
                for (int i = right; right > 0 && height[right] <= height[i] ; right--);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LeetCode_11_MostWater mostWater = new LeetCode_11_MostWater();
        {
            int height[] = {1,1};
            System.out.println("max Area:\t"+mostWater.maxArea(height));
        }
        {
            int height[] = {1,3,2,5,4,7};
            System.out.println("max Area:\t"+mostWater.maxArea(height));
        }
    }
}
