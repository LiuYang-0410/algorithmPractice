package 剑指offer;

import base.BinaryTreeNode;

/**
 * Created by liuyang on 16/4/25.
 */
public class NextInOrderBinaryNode58 {

    /**
     * 找到二叉树中序遍历的下一个节点
     * @param node 指定节点
     * @return  中序遍历下的下一个节点
     */
    public BinaryTreeNode nextNodeInOrder(BinaryTreeNode node){
        if (node == null)
            return null;
        BinaryTreeNode leftMost = node.rightNode;
        while (leftMost != null && leftMost.leftNode != null)
            leftMost = leftMost.leftNode;
        if (leftMost != null)   //存在右子树,则返回右子树中的最左节点
            return leftMost;
        BinaryTreeNode curNode = node;
        while (curNode.parent != null){    //不存在右子树,则返回能让当前节点作为左子树的节点
            if (curNode == curNode.parent.leftNode)
                return curNode.parent;
            else
                curNode = curNode.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        NextInOrderBinaryNode58 tool = new NextInOrderBinaryNode58();

        BinaryTreeNode nodeH = new BinaryTreeNode(8);
        BinaryTreeNode nodeI = new BinaryTreeNode(9);
        BinaryTreeNode nodeE = new BinaryTreeNode(5, nodeH,nodeI);
        nodeH.parent = nodeE;
        nodeI.parent = nodeE;

        BinaryTreeNode nodeD = new BinaryTreeNode(4);
        BinaryTreeNode nodeB = new BinaryTreeNode(2,nodeD,nodeE);
        nodeD.parent = nodeB;
        nodeE.parent = nodeB;

        BinaryTreeNode nodeF = new BinaryTreeNode(6);
        BinaryTreeNode nodeG = new BinaryTreeNode(7);
        BinaryTreeNode nodeC = new BinaryTreeNode(3, nodeF,nodeG);
        nodeF.parent = nodeC;
        nodeG.parent = nodeC;

        BinaryTreeNode nodeA = new BinaryTreeNode(1,nodeB,nodeC);
        nodeB.parent = nodeA;
        nodeC.parent = nodeA;

        System.out.println("A的下一个:\t"+tool.nextNodeInOrder(nodeA));
        System.out.println("B的下一个:\t"+tool.nextNodeInOrder(nodeB));
        System.out.println("C的下一个:\t"+tool.nextNodeInOrder(nodeC));
        System.out.println("D的下一个:\t"+tool.nextNodeInOrder(nodeD));
        System.out.println("E的下一个:\t"+tool.nextNodeInOrder(nodeE));
        System.out.println("F的下一个:\t"+tool.nextNodeInOrder(nodeF));
        System.out.println("G的下一个:\t"+tool.nextNodeInOrder(nodeG));
        System.out.println("H的下一个:\t"+tool.nextNodeInOrder(nodeH));
        System.out.println("I的下一个:\t"+tool.nextNodeInOrder(nodeI));
    }
}
