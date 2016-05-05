package 剑指offer;

import base.ListNode;
/**
 * Created by liuyang on 16/4/24.
 */
public class JosephuseCycle45 {

    /**
     * 0,1,..n-1几个数字排成圈,从数字0开始每次从圈里删除第m个数字,最后剩下的数字
     * @param n n个数字排成圈
     * @param m 删除第m个数字
     * @return  剩下的数字
     */
    public int restNumberAfterDelete(int n,int m){
        ListNode preNode = null;
        for (int i = n-1; i >= 0 ; i--) {   //构建有环链表
            ListNode node = new ListNode(i,preNode);
            preNode = node;
        }
        ListNode curNode = preNode;
        while (curNode.next != null)
            curNode = curNode.next;
        curNode.next = preNode;
        curNode = preNode;
        int count = 1;
        while (curNode.next != null){   //删除第m个节点
            if (count++ != m){
                curNode = curNode.next;
            }else {
                curNode.value = curNode.next.value;
                curNode.next = curNode.next.next;
                if (curNode.next == curNode)
                    curNode.next = null;
                count = 1;
            }
        }
        return curNode.value;
    }

    public static void main(String[] args) {
        JosephuseCycle45 tool = new JosephuseCycle45();
        System.out.println(tool.restNumberAfterDelete(5,3));
    }

}
