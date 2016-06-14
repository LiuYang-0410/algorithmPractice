package leetcode;

import base.ListNode;

/**
 * Created by liuyang on 16/5/3.
 */
public class LeetCode_2_AddTwoNumbers {

    /**
     * [大数相加问题]两个数以链表表示,低位在链表头,高位在链表尾
     * @param l1    第一个数的倒叙表示
     * @param l2    第二个数的倒叙表示
     * @return  两数之和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {   //4ms
        ListNode head = new ListNode(-1),curNode = head;
        ListNode node1 = l1, node2 = l2;
        boolean carry = false;  //是否需要进位
        while (node1 != null || node2 != null || carry){
            int value = 0;
            if (node1 != null){
                value += node1.val;
                node1 = node1.next;
            }
            if (node2 != null){
                value += node2.val;
                node2 = node2.next;
            }
            if (carry)
                value += 1;
            if (value >= 10){
                carry = true;
                value -= 10;
            }else
                carry = false;
            curNode.next = new ListNode(value);
            curNode = curNode.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        LeetCode_2_AddTwoNumbers tool = new LeetCode_2_AddTwoNumbers();
        {
            ListNode l1 = new ListNode(2);
            ListNode l2 = new ListNode(8);
            System.out.print("链表1:\t");
            ListNode.printList(l1);
            System.out.print("链表2:\t");
            ListNode.printList(l2);
            ListNode res1 = tool.addTwoNumbers(l1,l2);
            System.out.print("结果:\t");
            ListNode.printList(res1);
            System.out.println("***************************");
        }
        {
            ListNode l1 = new ListNode(2);
            ListNode l12 = new ListNode(4);
            l1.next = l12;
            ListNode l2 = new ListNode(5);
            ListNode l22 = new ListNode(6);
            l2.next = l22;
            ListNode l23 = new ListNode(2);
            l22.next = l23;
            System.out.print("链表1:\t");
            ListNode.printList(l1);
            System.out.print("链表2:\t");
            ListNode.printList(l2);
            ListNode res1 = tool.addTwoNumbers(l1,l2);
            System.out.print("结果:\t");
            ListNode.printList(res1);
            System.out.println("***************************");
            l12.next = new ListNode(3);
            System.out.print("链表1:\t");
            ListNode.printList(l1);
            System.out.print("链表2:\t");
            ListNode.printList(l2);
            ListNode res2 = tool.addTwoNumbers(l1,l2);
            System.out.print("结果:\t");
            ListNode.printList(res2);
        }
    }
}
