package leetcode;

import base.ListNode;

/**
 * Created by ly_anna on 2016/6/13.
 */
public class LeetCode_25_ReverseNodes {

    /**
     * 将链表中的元素每k个翻转一次
     */
    public ListNode reverseKGroup(ListNode head, int k) {//1ms
        if (k == 1 || head == null)
            return head;
        ListNode fakeHead = new ListNode(1),parentNode = fakeHead;
        fakeHead.next = head;
        while (parentNode.next != null){
            ListNode curNode = parentNode.next;
            for (int i = 1; i < k && curNode != null ; i++,curNode = curNode.next);
            if (curNode == null) break;
            curNode = parentNode.next;
            for (int i = 1; i < k; i++) {
                ListNode temp = parentNode.next;
                parentNode.next = curNode.next;
                curNode.next = curNode.next.next;
                parentNode.next.next = temp;
            }
            parentNode = curNode;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        LeetCode_25_ReverseNodes reverseNodes = new LeetCode_25_ReverseNodes();
        System.out.print("原链表：");
        ListNode.printList(ListNode.generateList("1,2,3,4,5,6"));
        for (int i = 1; i < 10; i++) {
            ListNode newHead = reverseNodes.reverseKGroup(ListNode.generateList("1,2,3,4,5,6"),i);
            System.out.print("翻转"+i+"个：");
            ListNode.printList(newHead);
            System.out.println("************************************************");
        }
    }
}
