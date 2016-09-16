package 剑指offer;

import base.*;
import java.util.LinkedList;
import java.util.Queue;

public class S_60_PrintBT {

	public void print(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNode curNode = queue.poll();
				System.out.print(curNode.value +"\t");
				if (curNode.leftNode != null) {
					queue.add(curNode.leftNode);
				}
				if (curNode.rightNode != null) {
					queue.add(curNode.rightNode);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node6 = new BinaryTreeNode(6,node5,node7);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		BinaryTreeNode node11 = new BinaryTreeNode(11);
		BinaryTreeNode node10 = new BinaryTreeNode(10,node9,node11);
		BinaryTreeNode root = new BinaryTreeNode(8,node6,node10);
		S_60_PrintBT printBT = new S_60_PrintBT();
		printBT.print(root);
	}

}
