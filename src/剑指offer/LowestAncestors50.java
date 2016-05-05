package 剑指offer;

import base.BinaryTreeNode;

/**
 * Created by liuyang on 16/4/25.
 */
public class LowestAncestors50 {

    /**
     * 二叉搜索树的最低公共祖先
     * @param root  BST的根
     * @param node1 要找的第一个节点
     * @param node2 要找的第二个节点
     * @return  最低公共祖先
     */
    public BinaryTreeNode getLowestAncestorInBST(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2){
        if (root == null)
            return null;
        int min = Math.min(node1.value, node2.value);
        int max = Math.max(node1.value, node2.value);
        if (root.value > min && root.value < max)
            return root;
        if (root.value > max)
            return getLowestAncestorInBST(root.leftNode,node1,node2);
        return getLowestAncestorInBST(root.rightNode,node1,node2);
    }

    /**
     * 二叉树的最低公共祖先
     * @param root  二叉树的根
     * @param node1 要找的第一个节点
     * @param node2 要找的第二个节点
     * @return  最低公共祖先
     */
    public BinaryTreeNode getLowestAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2){
        if (root == null)
            return null;
        if (root == node1 || root == node2) //找到待查节点
            return root;
        BinaryTreeNode temp1 = getLowestAncestor(root.leftNode,node1,node2);
        BinaryTreeNode temp2 = getLowestAncestor(root.rightNode,node1,node2);
        if (temp1 != null && temp2 != null) //待查节点一定一个在最低公共祖先的左子树,一个在右子树,temp1 temp2均不为空则找到最低公共祖先
            return root;
        return temp1 != null ? temp1 : temp2;   //未找到公共祖先,返回已找到的那个节点
    }

    public static void main(String[] args) {
        LowestAncestors50 tool = new LowestAncestors50();
        BinaryTreeNode nodeF = new BinaryTreeNode(2);
        BinaryTreeNode nodeG = new BinaryTreeNode(4);
        BinaryTreeNode nodeD = new BinaryTreeNode(3,nodeF,nodeG);

        BinaryTreeNode nodeH = new BinaryTreeNode(6);
        BinaryTreeNode nodeI = new BinaryTreeNode(9);
        BinaryTreeNode nodeE = new BinaryTreeNode(7,nodeH,nodeI);

        BinaryTreeNode nodeB = new BinaryTreeNode(5,nodeD,nodeE);
        BinaryTreeNode nodeC = new BinaryTreeNode(12);
        BinaryTreeNode nodeA = new BinaryTreeNode(10,nodeB,nodeC);

        System.out.println("***********二叉搜索树***********");
        System.out.println(tool.getLowestAncestorInBST(nodeA,nodeF,nodeE));
        System.out.println(tool.getLowestAncestorInBST(nodeA,nodeF,nodeC));

        System.out.println("***********二叉树***********");
        System.out.println(tool.getLowestAncestor(nodeA,nodeF,nodeE));
        System.out.println(tool.getLowestAncestor(nodeA,nodeF,nodeC));
    }

}
