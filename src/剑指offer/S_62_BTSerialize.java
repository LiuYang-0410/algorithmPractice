package 剑指offer;

import base.*;

public class S_62_BTSerialize {

	int desrializedIndex = 0;
	
	public String Serialize(BinaryTreeNode root) {
		if (root == null) {
			return "$";
		}
		return root.value + "," + Serialize(root.leftNode) + "," + Serialize(root.rightNode);
	}
	
	public BinaryTreeNode Desrialize(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		return helper(str.split(","));
	}
	
	private BinaryTreeNode helper(String[] temp) {
		if (desrializedIndex == temp.length) {
			return null;
		}
		String ch = temp[desrializedIndex++];
		if ("$".equals(ch)) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(ch));
		root.leftNode = helper(temp);
		root.rightNode = helper(temp);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S_62_BTSerialize btSerialize = new S_62_BTSerialize();
		BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(2,node4,null);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(3,node5,node6);
        BinaryTreeNode node1 = new BinaryTreeNode(1,node2,node3);

        String res = btSerialize.Serialize(node1);
        BinaryTreeNode node = btSerialize.Desrialize(res);
        System.out.println("序列化结果:\t"+res);
        System.out.println("反序列化结果:\t"+btSerialize.Serialize(node));
	}

}
