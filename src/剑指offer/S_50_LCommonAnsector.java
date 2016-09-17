package 剑指offer;

import base.*;

public class S_50_LCommonAnsector {
	
	private BinaryTreeNode find(BinaryTreeNode node, BinaryTreeNode childNode1, BinaryTreeNode childNode2) {
		if (node == null) {
			return node;
		}
		if (node == childNode1 || node == childNode2) {
			return node;
		}
		BinaryTreeNode left = find(node.leftNode, childNode1, childNode2);
		if (left != null && left != childNode1 && left != childNode2) {
			return left;
		}
		BinaryTreeNode right = find(node.rightNode, childNode1, childNode2);
		if (right != null && right != childNode1 && right != childNode2) {
			return right;
		}
		
		if (left == null && right == null) {
			return null;
		}
 		if (left != null && right != null) {
			return node;
		}
		return left != null ? left : right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node4 = new BinaryTreeNode(4,node3,node5);
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2,node1,node4);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		BinaryTreeNode node8 = new BinaryTreeNode(8,node7,node9);
		BinaryTreeNode node6 = new BinaryTreeNode(6,node2,node8);
		S_50_LCommonAnsector lCommonAnsector = new S_50_LCommonAnsector();
		System.out.println(lCommonAnsector.find(node6, node1, node7));
		System.out.println(lCommonAnsector.find(node6, node4, node9));
		System.out.println(lCommonAnsector.find(node6, node5, node7));
		System.out.println(lCommonAnsector.find(node6, node1, node5));
		System.out.println(lCommonAnsector.find(node6, node7, node9));		
	}

}
