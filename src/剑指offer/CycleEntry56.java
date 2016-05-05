package 剑指offer;

import base.ListNode;
/**
 * Created by liuyang on 16/4/25.
 */
public class CycleEntry56 {

    /**
     * 找到链表中的入口节点
     * @param head  链表头
     * @return  入口节点
     */
    public ListNode cycleEntryInList(ListNode head){
        if (head == null)
            return null;
        ListNode slow = head, fast = head.next;
        int count = 1;
        while (fast != null){
            if (fast == slow){  //找到环中某点
                //计算环的节点数
                while (slow.next != fast){
                    slow = slow.next;
                    count++;
                }
                break;
            }else {
                slow = slow.next;
                fast = fast.next;
                if (fast == null)
                    return null;
                fast = fast.next;
            }
        }
        slow = head;
        fast = head;
        while (count-- > 0)
            fast = fast.next;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        CycleEntry56 tool = new CycleEntry56();
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println("********链表无环********");
        System.out.println("环的入口:\t"+tool.cycleEntryInList(node1));
        node6.next = node3;
        System.out.println("********链表有环********");
        System.out.println("环的入口:\t"+tool.cycleEntryInList(node1));
    }

}
