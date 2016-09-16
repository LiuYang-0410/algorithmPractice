package 剑指offer;

import base.*;

public class S_59_MirrorBT {

	public boolean isMirror(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		String anString= helper(root);
		if ((anString.length() & 1) != 1) {	//中序遍历的结果应该为奇数
			return false;
		}
		for (int i = 0, j = anString.length()-1; i < j; i++,j--) {
			if (anString.charAt(i) != anString.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	private String helper(BinaryTreeNode node) {	//中序遍历的结果
		if (node == null) {
			return "null";
		}
		if (node.leftNode == null && node.rightNode == null) {
			return String.valueOf(node.value);
		}
		String left = helper(node.leftNode);
		String right = helper(node.rightNode);
		String ans = null;
		if (left != null) {
			ans = left + ",";
		}
		ans += node.value;
		if (right != null) {
			ans += "," + right;
		}
		return ans;
	}
	
	public boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}
	
	private boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.value != root2.value) {
			return false;
		}
		return isSymmetrical(root1.leftNode, root2.rightNode) 
				&& isSymmetrical(root1.rightNode, root2.leftNode);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			BinaryTreeNode node1 = new BinaryTreeNode(5);
			BinaryTreeNode node2 = new BinaryTreeNode(7);
			BinaryTreeNode node3 = new BinaryTreeNode(6,node1,node2);
			BinaryTreeNode node4 = new BinaryTreeNode(7);
			BinaryTreeNode node5 = new BinaryTreeNode(5);
			BinaryTreeNode node6 = new BinaryTreeNode(6,node4,node5);
			BinaryTreeNode node7 = new BinaryTreeNode(8,node3,node6);
			S_59_MirrorBT mirrorBT = new S_59_MirrorBT();
			System.out.println(mirrorBT.isMirror(node7));
			System.out.println(mirrorBT.isSymmetrical(node7));
		}
		{
			BinaryTreeNode node1 = new BinaryTreeNode(5);
			BinaryTreeNode node2 = new BinaryTreeNode(7);
			BinaryTreeNode node3 = new BinaryTreeNode(6,node1,node2);
			BinaryTreeNode node4 = new BinaryTreeNode(7);
			BinaryTreeNode node5 = new BinaryTreeNode(5);
			BinaryTreeNode node6 = new BinaryTreeNode(9,node4,node5);
			BinaryTreeNode node7 = new BinaryTreeNode(8,node3,node6);
			S_59_MirrorBT mirrorBT = new S_59_MirrorBT();
			System.out.println(mirrorBT.isMirror(node7));
			System.out.println(mirrorBT.isSymmetrical(node7));
		}
		{
			BinaryTreeNode node1 = new BinaryTreeNode(7);
			BinaryTreeNode node2 = new BinaryTreeNode(7);
			BinaryTreeNode node3 = new BinaryTreeNode(7,node1,node2);
			BinaryTreeNode node4 = new BinaryTreeNode(7);
			BinaryTreeNode node6 = new BinaryTreeNode(7,node4,null);
			BinaryTreeNode node7 = new BinaryTreeNode(7,node3,node6);
			S_59_MirrorBT mirrorBT = new S_59_MirrorBT();
			System.out.println(mirrorBT.isMirror(node7));
			System.out.println(mirrorBT.isSymmetrical(node7));
		}
	}

}
