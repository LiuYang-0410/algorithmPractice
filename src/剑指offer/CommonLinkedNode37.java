package 剑指offer;

import base.ListNode;

/**
 * Created by liuyang on 16/4/22.
 */
public class CommonLinkedNode37 {

    /**
     * 获取单链表的第一个公共节点(无环)
     * @param list1 链表1
     * @param list2 链表2
     * @return  公共节点
     */
    public ListNode getFirstCommonNode(ListNode list1, ListNode list2){
        if (list1 == null || list2 == null)
            return null;
        int length1 = 0,length2 = 0;
        ListNode node1 = list1,node2 = list2;
        while (node1 != null){  //list1的长度
            length1++;
            node1 = node1.next;
        }
        while (node2 != null){  //list2的长度
            length2++;
            node2 = node2.next;
        }
        int diff = length1 - length2;
        node1 = list1;
        node2 = list2;
        while (diff > 0){//list1 比 list2长
            node1 = node1.next;
            diff--;
        }
        while (diff < 0){//list2 比 list1长
            node2 = node1.next;
            diff++;
        }

        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }


    /**
     *  公共节点在链表中间
     */
    public void testMidCommon(){
        System.out.println("************公共节点在链表中间************");
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node6);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println("链表1:");
        ListNode.printList(node1);
        System.out.println("链表2:");
        ListNode.printList(node4);
        System.out.println("公共节点:\n"+getFirstCommonNode(node1,node4));
    }

    /**
     * 公共节点在链表尾
     */
    public void testEndCommon(){
        System.out.println("************公共节点在链表尾************");
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node6);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println("链表1:");
        ListNode.printList(node1);
        System.out.println("链表2:");
        ListNode.printList(node4);
        System.out.println("公共节点:\n"+getFirstCommonNode(node1,node4));
    }
    /**
     * 公共节点在链表头
     */
    public void testHeadCommon(){
        System.out.println("************公共节点在链表头************");
        ListNode node6 = new ListNode(6);
        ListNode node3 = new ListNode(3,node6);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println("链表1:");
        ListNode.printList(node1);
        System.out.println("链表2:");
        ListNode.printList(node1);
        System.out.println("公共节点:\n"+getFirstCommonNode(node1,node1));
    }

    /**
     *  没有公共节点
     */
    public void testNoCommon(){
        System.out.println("************没有公共节点************");
        ListNode node6 = new ListNode(6);
        ListNode node3 = new ListNode(3,node6);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        System.out.println("链表1:");
        ListNode.printList(node1);
        System.out.println("链表2:");
        ListNode.printList(node4);
        System.out.println("公共节点:\n"+getFirstCommonNode(node1,node4));
    }


    public static void main(String[] args) {
        CommonLinkedNode37 tool = new CommonLinkedNode37();
        tool.testNoCommon();
        tool.testHeadCommon();
        tool.testMidCommon();
        tool.testEndCommon();
    }
}
