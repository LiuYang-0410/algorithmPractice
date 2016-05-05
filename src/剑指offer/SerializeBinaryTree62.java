package 剑指offer;

import base.BinaryTreeNode;

/**
 * Created by liuyang on 16/4/25.
 */
public class SerializeBinaryTree62 {

    /**
     * 序列化二叉树
     * @param root  二叉树的根
     * @return  字符串表示的序列化结果,null用$表示
     */
    public String serialize(BinaryTreeNode root){
        StringBuffer sb = new StringBuffer();
        serializeHelper(root,sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private void serializeHelper(BinaryTreeNode root, StringBuffer sb){
        if (root == null){
            sb.append("$,");
            return;
        }
        sb.append(root.value).append(",");
        serializeHelper(root.leftNode,sb);
        serializeHelper(root.rightNode,sb);
    }

    int index;

    /**
     * 反序列化二叉树
     * @param string    序列化结果
     * @return  二叉树的根
     */
    public BinaryTreeNode deSerialize(String string){
        if (string == null || string.isEmpty())
            return null;
        index = 0;
        return deSerializeHelper(string.split(","));
    }

    public BinaryTreeNode deSerializeHelper(String string[]){
        if (index == string.length || "$".equals(string[index])){
            index++;
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(string[index++]));
        node.leftNode = deSerializeHelper(string);
        node.rightNode = deSerializeHelper(string);
        return node;
    }

    public static void main(String[] args) {
        SerializeBinaryTree62 tool = new SerializeBinaryTree62();
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(2,node4,null);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(3,node5,node6);
        BinaryTreeNode node1 = new BinaryTreeNode(1,node2,node3);

        String res = tool.serialize(node1);
        BinaryTreeNode node = tool.deSerialize(res);
        System.out.println("序列化结果:\t"+res);
        System.out.println("反序列化结果:\t"+tool.serialize(node));

    }

}
