package leetcode;

/**
 * Created by liuyang on 16/5/5.
 */
public class LeetCode_4_MedianInTwoSortedArrays {

    /**
     * 关键在于一次去掉要找的第k个数字的前面的一半
     */

    /**
     * 找两个排序数组的中位数
     * @param nums1 数组1
     * @param nums2 数组2
     * @return  中位数
     */
    public double findMedianSortedArrays(int nums1[],int nums2[]){  //5ms
        int leftIndex = (nums1.length + nums2.length+1)/2;
        int rightIndex = (nums1.length + nums2.length+2)/2;
        if (leftIndex == rightIndex)
            return findKth(nums1,0,nums2,0,leftIndex);
        return (findKth(nums1,0,nums2,0,leftIndex)+findKth(nums1,0,nums2,0,rightIndex))/2.0;
    }

    private int findKth(int nums1[],int start1,int nums2[],int start2,int k){
        if (start1 >= nums1.length) return nums2[start2+k-1];
        if (start2 >= nums2.length) return  nums1[start1+k-1];
        if (k == 1) return Math.min(nums1[start1],nums2[start2]);
        int mid1 = Integer.MAX_VALUE,mid2 = Integer.MAX_VALUE;
        if (start1 + k/2 -1 < nums1.length)  mid1 = nums1[start1 + k/2 -1];
        if (start2 + k/2 -1 < nums2.length)  mid2 = nums2[start2 + k/2 -1];
        if (mid1 < mid2)
            return findKth(nums1,start1 + k/2,nums2,start2,k-k/2);
        else
            return findKth(nums1,start1,nums2,start2 + k/2,k-k/2);
    }

    public static void main(String[] args) {
        LeetCode_4_MedianInTwoSortedArrays tool = new LeetCode_4_MedianInTwoSortedArrays();
        System.out.println("***********两个数组有一个为空***********");
        {
            int nums1[] = {};
            int nums2[] = {1};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1};
            int nums2[] = {};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {};
            int nums2[] = {2,3};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1,3,5};
            int nums2[] = {};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        System.out.println("***********两个数组都不为空***********");
        {
            int nums1[] = {1};
            int nums2[] = {2,3,4,5,6};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1,1};
            int nums2[] = {1,2};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1,2};
            int nums2[] = {1,1};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1,4};
            int nums2[] = {2,3};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1,2,3};
            int nums2[] = {4,5,6};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {4,5,6};
            int nums2[] = {1,2,3};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {2,4,9,10};
            int nums2[] = {3,6,7,8,11};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
        {
            int nums1[] = {1,6,9};
            int nums2[] = {2,4,10};
            System.out.println(tool.findMedianSortedArrays(nums1,nums2));
        }
    }

}
