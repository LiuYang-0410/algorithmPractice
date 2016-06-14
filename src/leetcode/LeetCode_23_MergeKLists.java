package leetcode;

import base.ListNode;

/**
 * Created by ly_anna on 2016/5/31.
 */
public class LeetCode_23_MergeKLists {

    /**
     * 合并k个排序链表
     */
    public ListNode mergeKLists(ListNode[] lists) { //分治 4ms
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        return divide(lists,0,lists.length-1);
    }

    private ListNode divide(ListNode lists[], int begin, int end){
        if (begin == end)
            return lists[end];
        int mid = (begin + end)/2;
        ListNode left = divide(lists,begin,mid);
        ListNode right = divide(lists,mid+1,end);
        ListNode fakeHead = new ListNode(1),curNode = fakeHead;
        while (left != null && right != null){
            if (left.val <= right.val){
                curNode.next = left;
                left = left.next;
            }else {
                curNode.next = right;
                right = right.next;
            }
            curNode = curNode.next;
        }
        curNode.next = left != null ? left : right;
        return fakeHead.next;
    }

    public static void main(String[] args) {
        LeetCode_23_MergeKLists mergeKLists = new LeetCode_23_MergeKLists();
        {
            ListNode nodes[] = {ListNode.generateList("3,3,5,7,9,14"),
                    ListNode.generateList("1,2,4,6,12,45"),
                    ListNode.generateList("6,7,13,21")};
            ListNode newHead = mergeKLists.mergeKLists(nodes);
            ListNode.printList(newHead);
        }
    }
}
