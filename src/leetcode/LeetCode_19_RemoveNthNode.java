package leetcode;

import base.ListNode;

/**
 * Created by ly_anna on 2016/5/30.
 */
public class LeetCode_19_RemoveNthNode {

    /**
     * 移除链表中倒数第n个节点
     * @param head  链表头
     * @param n 倒数第n个，n一定有效
     * @return  移除后的链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {    //1ms
        ListNode fakeHead = new ListNode(0,head), fast = fakeHead, slow = fakeHead;
        while (n-- > 0)
            fast = fast.next;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }

    public static void main(String[] args) {
        LeetCode_19_RemoveNthNode removeNode = new LeetCode_19_RemoveNthNode();
        {
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4,node5);
            ListNode node3 = new ListNode(3,node4);
            ListNode node2 = new ListNode(2,node3);
            ListNode node1 = new ListNode(1,node2);
            System.out.print("原链表:\t");
            ListNode.printList(node1);
            ListNode newHead = removeNode.removeNthFromEnd(node1,1);
            System.out.print("删除后的链表:\t");
            ListNode.printList(newHead);
        }
        {
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4,node5);
            ListNode node3 = new ListNode(3,node4);
            ListNode node2 = new ListNode(2,node3);
            ListNode node1 = new ListNode(1,node2);
            System.out.print("原链表:\t");
            ListNode.printList(node1);
            ListNode newHead = removeNode.removeNthFromEnd(node1,2);
            System.out.print("删除后的链表:\t");
            ListNode.printList(newHead);
        }
        {
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4,node5);
            ListNode node3 = new ListNode(3,node4);
            ListNode node2 = new ListNode(2,node3);
            ListNode node1 = new ListNode(1,node2);
            System.out.print("原链表:\t");
            ListNode.printList(node1);
            ListNode newHead = removeNode.removeNthFromEnd(node1,3);
            System.out.print("删除后的链表:\t");
            ListNode.printList(newHead);
        }
        {
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4,node5);
            ListNode node3 = new ListNode(3,node4);
            ListNode node2 = new ListNode(2,node3);
            ListNode node1 = new ListNode(1,node2);
            System.out.print("原链表:\t");
            ListNode.printList(node1);
            ListNode newHead = removeNode.removeNthFromEnd(node1,4);
            System.out.print("删除后的链表:\t");
            ListNode.printList(newHead);
        }
        {
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4,node5);
            ListNode node3 = new ListNode(3,node4);
            ListNode node2 = new ListNode(2,node3);
            ListNode node1 = new ListNode(1,node2);
            System.out.print("原链表:\t");
            ListNode.printList(node1);
            ListNode newHead = removeNode.removeNthFromEnd(node1,5);
            System.out.print("删除后的链表:\t");
            ListNode.printList(newHead);
        }
    }
}
