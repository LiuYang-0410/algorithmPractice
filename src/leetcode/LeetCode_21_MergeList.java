package leetcode;

import base.ListNode;

/**
 * Created by ly_anna on 2016/5/31.
 */
public class LeetCode_21_MergeList {

    /**
     * 合并两个排序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//1ms
        ListNode cur1 = l1, cur2 = l2, fakeHead = new ListNode(1),curNode = fakeHead;
        while (cur1 != null && cur2 != null){
            if (cur1.val <= cur2.val){
                curNode.next = cur1;
                cur1 = cur1.next;
            }else {
                curNode.next = cur2;
                cur2 = cur2.next;
            }
            curNode = curNode.next;
        }
        if (cur1 != null) curNode.next = cur1;
        if (cur2 != null) curNode.next = cur2;
        return fakeHead.next;
    }

    public static void main(String[] args) {
        LeetCode_21_MergeList mergeList = new LeetCode_21_MergeList();
        {
            System.out.println("****************l1,l2都不为空********************");
            ListNode node5 = new ListNode(5);
            ListNode node3 = new ListNode(3,node5);
            ListNode node1 = new ListNode(1,node3);
            ListNode node8 = new ListNode(8);
            ListNode node6 = new ListNode(6,node8);
            ListNode node4 = new ListNode(4,node6);
            ListNode node2 = new ListNode(2,node4);
            ListNode newList = mergeList.mergeTwoLists(node1,node2);
            ListNode.printList(newList);
        }
        {
            System.out.println("****************l2为空********************");
            ListNode node5 = new ListNode(5);
            ListNode node3 = new ListNode(3,node5);
            ListNode node1 = new ListNode(1,node3);
            ListNode newList = mergeList.mergeTwoLists(node1,null);
            ListNode.printList(newList);
        }
        {
            System.out.println("****************l1为空********************");
            ListNode node6 = new ListNode(6);
            ListNode node4 = new ListNode(4,node6);
            ListNode node2 = new ListNode(2,node4);
            ListNode newList = mergeList.mergeTwoLists(null,node2);
            ListNode.printList(newList);
        }
    }
}
