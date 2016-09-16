package 剑指offer;

import base.BinaryTreeNode;

public class S_63_KBST {

	int count = 0;
	
	public BinaryTreeNode findNode(BinaryTreeNode curNode) {
		if (curNode == null) {
			return null;
		}
		BinaryTreeNode target = findNode(curNode.leftNode);
		if (target != null) {
			return target;
		}
		if (count-- == 1) {
			return curNode;
		}
		return findNode(curNode.rightNode);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S_63_KBST kbst = new S_63_KBST();
		kbst.count = 3;
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, node2, node4);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node7 = new BinaryTreeNode(7,node6,node8);
		BinaryTreeNode root = new BinaryTreeNode(5,node3,node7);
		BinaryTreeNode kNode = kbst.findNode(root);
		System.out.println(kNode);
	}

}
