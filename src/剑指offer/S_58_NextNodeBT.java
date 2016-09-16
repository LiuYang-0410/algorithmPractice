package 剑指offer;

import java.util.Stack;

import base.*;

public class S_58_NextNodeBT {

	public BinaryTreeNode nextNode(BinaryTreeNode root, BinaryTreeNode target) {
		boolean find = false;
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode curNode = root;
		while (!stack.isEmpty() || curNode != null) {
			if (curNode != null) {
				stack.add(curNode);
				curNode = curNode.leftNode; 
			}else {
				BinaryTreeNode peek = stack.pop();
				curNode = peek.rightNode;
				if (find) {
					return peek;
				}
				if (peek == target) {
					find = true;
				}
			}
		}
		return null;
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
		S_58_NextNodeBT nextNodeBT = new S_58_NextNodeBT();
		System.out.println("1 -> " + nextNodeBT.nextNode(node6, node1));
		System.out.println("2 -> " + nextNodeBT.nextNode(node6, node2));
		System.out.println("3 -> " + nextNodeBT.nextNode(node6, node3));
		System.out.println("4 -> " + nextNodeBT.nextNode(node6, node4));
		System.out.println("5 -> " + nextNodeBT.nextNode(node6, node5));
		System.out.println("6 -> " + nextNodeBT.nextNode(node6, node6));
		System.out.println("7 -> " + nextNodeBT.nextNode(node6, node7));
		System.out.println("8 -> " + nextNodeBT.nextNode(node6, node8));
		System.out.println("9 -> " + nextNodeBT.nextNode(node6, node9));
		
		
	}

}
