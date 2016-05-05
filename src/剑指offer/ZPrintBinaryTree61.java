package 剑指offer;

import base.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by liuyang on 16/4/25.
 */
public class ZPrintBinaryTree61 {

    /**
     * 之字型打印二叉树
     * @param root  二叉树的根
     */
    public void printBinaryTree(BinaryTreeNode root){
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack[] = new Stack[2];
        stack[0] = new Stack<>();   //保存奇数层
        stack[1] = new Stack<>();   //保存偶数层
        stack[0].push(root);
        int curIndex = 0;
        while (!stack[curIndex].isEmpty()){
            while (!stack[curIndex].isEmpty()){
                BinaryTreeNode curNode = stack[curIndex].pop();
                System.out.print(curNode.value+"\t");
                if (curIndex == 0)
                    addNodeToStack(curNode.leftNode, curNode.rightNode,stack[1]);
                else
                    addNodeToStack(curNode.rightNode, curNode.leftNode,stack[0]);
            }
            System.out.println();
            curIndex = (curIndex+1)%2;
        }
    }

    private void addNodeToStack(BinaryTreeNode node1, BinaryTreeNode node2 , Stack stack){
        if (node1 != null)
            stack.push(node1);
        if (node2 != null)
            stack.push(node2);
    }


    public static void main(String[] args) {
        ZPrintBinaryTree61 tool = new ZPrintBinaryTree61();
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node4 = new BinaryTreeNode(4,node8,node9);

        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node5 = new BinaryTreeNode(5,node10,node11);

        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node6 = new BinaryTreeNode(6,node12,node13);

        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node15 = new BinaryTreeNode(15);
        BinaryTreeNode node7 = new BinaryTreeNode(7,node14,node15);

        BinaryTreeNode node2 = new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3,node6,node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1,node2,node3);

        tool.printBinaryTree(node1);
    }
}
