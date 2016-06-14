package leetcode;

import base.ListNode;

/**
 * Created by ly_anna on 2016/6/13.
 */
public class LeetCode_24_SwapNodes {

    /**
     * 交换链表中相邻节点
     */
    public ListNode swapPairs(ListNode head) {//0ms
        if (head == null || head.next == null)
            return head;
        ListNode fakeHead = new ListNode(1),parentNode = fakeHead, curNode = head;
        while (curNode != null && curNode.next != null){
            ListNode temp = curNode.next;
            curNode.next = temp.next;
            temp.next = curNode;
            parentNode.next = temp;
            parentNode = curNode;
            curNode = curNode.next;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        LeetCode_24_SwapNodes swapNodes = new LeetCode_24_SwapNodes();
        String aa[] = {"1","1,2","1,2,3,4,5","1,2,3,4,5,6"};
        for (String str : aa) {
            System.out.println("************************************************");
            ListNode head = ListNode.generateList(str);
            System.out.print("原链表：");
            ListNode.printList(head);
            ListNode newHead = swapNodes.swapPairs(head);
            System.out.print("交换后的链表：");
            ListNode.printList(newHead);
            System.out.println("************************************************");
        }
    }
}
