package 剑指offer;

import base.BinaryTreeNode;
/**
 * Created by liuyang on 16/4/13.
 */
public class ConvertBST27 {

    /**
     * 将二叉搜索树转换为排序的双向链表
     * @param root 二叉搜索树的根
     * @return  双向链表的表头
     */
    public BinaryTreeNode convert(BinaryTreeNode root){
        if (root == null || root.leftNode == null && root.rightNode == null)
            return root;
        BinaryTreeNode listHead = root;
        if (root.leftNode != null){
            listHead = convert(root.leftNode);  //转换左子树,最左节点作为链表头

            BinaryTreeNode rightMost = root.leftNode;
            while (rightMost != null && rightMost.rightNode != null)//寻找左子树中的最右节点
                rightMost = rightMost.rightNode;
            root.leftNode = rightMost;  //根节点的左边和左子树的最右节点相连
            rightMost.rightNode = root;
        }

        if (root.rightNode != null){
            BinaryTreeNode leftMost = convert(root.rightNode);  //转换右子树,获得右子树的最左节点
            root.rightNode = leftMost;  //根节点的右边
            leftMost.leftNode = root;
        }
        return listHead;
    }

    public void printDoubleLinkedList(BinaryTreeNode head){
        if (head == null)
            return;
        System.out.print("正向:");
        BinaryTreeNode curNode = head;
        while (curNode != null && curNode.rightNode != null){
            System.out.print(curNode+"\t");
            curNode = curNode.rightNode;
        }
        System.out.println(curNode);    //尾节点
        System.out.print("逆向:");
        while (curNode != null){
            System.out.print(curNode+"\t");
            curNode = curNode.leftNode;
        }
        System.out.println();
    }

    /**
     * 测试完全二叉树
     */
    public void testFullBST(){
        System.out.println("****************完全二叉树****************");
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6,node4,node8);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node16 = new BinaryTreeNode(16);
        BinaryTreeNode node14 = new BinaryTreeNode(14,node12,node16);
        BinaryTreeNode node10 = new BinaryTreeNode(10,node6,node14);
        BinaryTreeNode listHead = convert(node10);
        printDoubleLinkedList(listHead);
    }

    /**
     * 测试所有节点都没有右子树的二叉树
     */
    public void testLeftBST(){
        System.out.println("****************所有节点都没有右子树的二叉树****************");
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2,node1,null);
        BinaryTreeNode node3 = new BinaryTreeNode(3,node2,null);
        BinaryTreeNode node4 = new BinaryTreeNode(4,node3,null);
        BinaryTreeNode node5 = new BinaryTreeNode(5,node4,null);
        BinaryTreeNode listHead = convert(node5);
        printDoubleLinkedList(listHead);
    }
    /**
     * 测试所有节点都没有左子树的二叉树
     */
    public void testRightBST(){
        System.out.println("****************所有节点都没有左子树的二叉树****************");
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4,null,node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3,null,node4);
        BinaryTreeNode node2 = new BinaryTreeNode(2,null,node3);
        BinaryTreeNode node1 = new BinaryTreeNode(1,null,node2);
        BinaryTreeNode listHead = convert(node1);
        printDoubleLinkedList(listHead);
    }

    /**
     * 测试只有一个节点的二叉树
     */
    public void testSingleNodeBST(){
        System.out.println("****************只有一个节点的二叉树****************");
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode listHead = convert(node1);
        printDoubleLinkedList(listHead);
    }



    public static void main(String[] args) {
        ConvertBST27 solution = new ConvertBST27();
        solution.testFullBST();
        solution.testLeftBST();
        solution.testRightBST();
        solution.testSingleNodeBST();
    }

}
