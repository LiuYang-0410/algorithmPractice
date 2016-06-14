package 剑指offer;

import base.ListNode;

/**
 * Created by liuyang on 16/4/25.
 */
public class DeleteDuplication57 {

    /**
     * 删除链表中的重复结点
     * @param head  链表头
     */
    public void  deleteDuplicateNode(ListNode head){
        ListNode curNode = head,preNode = new ListNode(-1,head);
        while (curNode != null && curNode.next != null){
            if (curNode.val == curNode.next.val){//是重复节点
                preNode.next = curNode.next.next;
                curNode = preNode.next;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
    }

    public static void main(String[] args) {
        DeleteDuplication57 tool = new DeleteDuplication57();
        ListNode node5 = new ListNode(5);
        ListNode node42 = new ListNode(4,node5);
//        base.ListNode node42 = new base.ListNode(4);
        ListNode node41 = new ListNode(4,node42);
        ListNode node32 = new ListNode(3,node41);
        ListNode node31 = new ListNode(3,node32);
        ListNode node2 = new ListNode(2,node31);
        ListNode node1 = new ListNode(1,node2);
        tool.deleteDuplicateNode(node1);
        ListNode.printList(node1);
    }
}
